package com.yimew.config.shiro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class JwtAuthenticationFilter extends AuthenticatingFilter {
	@Value("${jwt.token.name}")
    private  String TOKEN = "authtoken";
	@Value("${adminUrl}")
	private String adminUrl = "http://test1.yilindai.com:8088/login";//"http://test1.yilindai.com:8088/login";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 先从Header里面获取
        String token = httpRequest.getHeader(TOKEN);
        if(StringUtils.isEmpty(token)){
            // 获取不到再从Parameter中拿
            token = httpRequest.getParameter(TOKEN);
            logger.info("获取tokenkey"+token);
            // 还是获取不到再从Cookie中拿
            if(StringUtils.isEmpty(token)){
                Cookie[] cookies = httpRequest.getCookies();
                if(cookies != null){
                    for (Cookie cookie : cookies) {
                    	  logger.info("获取toke全部"+cookie.getName()+cookie.getValue());
                        if(TOKEN.equals(cookie.getName())){
                            token = cookie.getValue();
                            break;
                        }
                    }
                }
            }
        }
        
        return JwtToken.builder()
                .token(token)
                .build();
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    	  HttpServletRequest httpRequest = (HttpServletRequest) request;
    	  System.out.println(httpRequest.getServletPath()+"路径");
          // 先从Header里面获取
          String token = httpRequest.getHeader(TOKEN);
          if(StringUtils.isEmpty(token)){
              // 获取不到再从Parameter中拿
              token = httpRequest.getParameter(TOKEN);
              // 还是获取不到再从Cookie中拿
              if(StringUtils.isEmpty(token)){
                  Cookie[] cookies = httpRequest.getCookies();
                  if(cookies != null){
                      for (Cookie cookie : cookies) {
                    	  logger.info("获取toke全部"+cookie.getName()+cookie.getValue());
                          if(TOKEN.equals(cookie.getName())){
                              token = cookie.getValue();
                              break;
                          }
                      }
                  }
              }
          }

        try {
            //5、委托给Realm进行登录
            getSubject(request, response).login(JwtToken.builder()
                    .token(token)
                    .build());
        } catch (Exception e) {
//        	HttpServletResponse httpResponse = (HttpServletResponse) response;
//    		httpResponse.sendRedirect(adminUrl);
        	logger.info("获取token 异常"+e);
        	 return executeLogin(request, response);
        }
        return true;
//        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        return true;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae, ServletRequest request,
                                     ServletResponse response) {
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        Map<String,Object> jsonObject = new HashMap<String,Object>();
        jsonObject.put("code", HttpServletResponse.SC_UNAUTHORIZED);
        jsonObject.put("msg","登录失败，无权访问");
        jsonObject.put("timestamp", System.currentTimeMillis());
        try {
            servletResponse.setCharacterEncoding("UTF-8");
            servletResponse.setContentType("application/json;charset=UTF-8");
            servletResponse.setHeader("Access-Control-Allow-Origin","*");
            servletResponse.sendRedirect(adminUrl);
            ObjectMapper objectMapper = new ObjectMapper();
            response.getWriter().write(objectMapper.writeValueAsString(jsonObject));
        } catch (IOException e) {
        }
        return false;
    }
}
