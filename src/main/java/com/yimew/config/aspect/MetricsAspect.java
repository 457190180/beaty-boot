package com.yimew.config.aspect;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codahale.metrics.MetricRegistry.name;

/**
 * Metrics性能监控配置，用于记录service层方法调用时间
 */
@Aspect
@Component
public class MetricsAspect {

	@Autowired
	private MetricRegistry metrics;

	/**
	 * 匹配service层的方法
	 */
	@Pointcut(value = "(execution(* com.yimew.*.service.*.*(..)))")
	private void servicePointcut() {
	}

	@Around(value = "servicePointcut()")
	public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
		Class cls = joinPoint.getTarget().getClass();
		String signature = joinPoint.getSignature().getName();
		final Timer requests = metrics.timer(name(cls, signature));
		Timer.Context context = requests.time();
		Object result;
		try {
			result = joinPoint.proceed();
		} finally {
			context.stop();
		}
		return result;
	}
}