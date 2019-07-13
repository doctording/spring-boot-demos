package com.example.demo.api;

import com.example.demo.api.handler.AuthHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author mubi
 * @Date 2019/7/13 8:35 PM
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个，这里选择拦截所有请求地址，进入后判断是否有加注解即可
        registry.addInterceptor(new AuthHandler()).addPathPatterns("/**");
    }
}