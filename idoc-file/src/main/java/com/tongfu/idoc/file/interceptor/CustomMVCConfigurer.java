package com.tongfu.idoc.file.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * @Author: SiJie Zhi
 * @Date: 2018/9/22 21:30
 */
@Configuration
public class CustomMVCConfigurer implements WebMvcConfigurer {

    @Bean
    LoginInterceptor localInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(localInterceptor()).addPathPatterns("/api/*/**");//拦截1
       // registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/api/*/**");//拦截2
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
