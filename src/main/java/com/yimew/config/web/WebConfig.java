package com.yimew.config.web;


import com.yimew.config.filter.CorsFilter;
import com.yimew.config.filter.CsrfFilter;
import com.yimew.config.filter.HttpCacheFilter;
import com.yimew.config.filter.RequestInfoFilter;
import com.yimew.config.filter.xss.XssSqlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Web配置，用于注入过滤器，拦截器等
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean xssFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new XssFilter());
        registration.setFilter(new XssSqlFilter());
        registration.addUrlPatterns("/*");
        registration.setName("xssFilter");
        registration.setOrder(10);
        return registration;
    }

    @Bean
    public FilterRegistrationBean csrfFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CsrfFilter());
        registration.addUrlPatterns("/*");
        registration.setName("csrfFilter");
        registration.setOrder(9);
        return registration;
    }

    @Bean
    public FilterRegistrationBean requestInfoFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestInfoFilter());
        registration.addUrlPatterns("/*");
        registration.setName("RequestInfoFilter");
        registration.setOrder(8);
        return registration;
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CorsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("corsFilter");
        registration.setOrder(7);
        return registration;
    }

    @Bean
    public FilterRegistrationBean httpCacheFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HttpCacheFilter());
        registration.addUrlPatterns("/*");
        registration.setName("httpCacheFilter");
        registration.addInitParameter("maxAge", String.valueOf(60 * 60 * 24 * 7));
        registration.setOrder(6);
        return registration;
    }

}
