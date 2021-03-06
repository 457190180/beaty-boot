package com.yimew.config.aspect;

import com.yimew.utils.GsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 用于记录调用controller层返回日志
 */
@Aspect
@Component
public class ResponseLogAspect {
	private static Logger logger = LoggerFactory.getLogger(ResponseLogAspect.class);

	/**
	 * 匹配controller层的方法
	 */
	@Pointcut(value = "(execution(* com.yimew.*.rest.*.*(..)))")
	private void controllerPointcut() {
	}

	@Around(value = "controllerPointcut()")
	public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = joinPoint.proceed();
		logger.info("==================== 调用Controller层返回json值 ====================");
		logger.info(GsonUtil.toJson(result));
		return result;
	}
}