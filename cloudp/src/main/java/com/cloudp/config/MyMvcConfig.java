package com.cloudp.config;

import com.cloudp.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("").setViewName("");
    }
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/goods/cart");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/user/info");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/goods/check");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/user/addToCart");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/cart/delete");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/index").setViewName("index");
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/login").setViewName("login-register");
                registry.addViewController("/regist").setViewName("login-register");
                registry.addViewController("/goods/check").setViewName("checkout");
                registry.addViewController("/user/info").setViewName("my-account");
                registry.addViewController("/index/about-us").setViewName("about-us");
                registry.addViewController("/index/map").setViewName("contact-us");
            }
        };


        return adapter;
    }
}
