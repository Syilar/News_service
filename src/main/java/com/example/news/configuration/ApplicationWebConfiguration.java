//package com.example.news.configuration;
//
//import com.example.news.web.interceptors.LoggingControllerInterceptor;
//import com.example.news.web.interceptors.UserControllerInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class ApplicationWebConfiguration implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loggingControllerInterceptor());
//        registry.addInterceptor(userControllerInterceptor())
//                .addPathPatterns("/api/v1/user/**");
//    }
//
//    @Bean
//    public LoggingControllerInterceptor loggingControllerInterceptor() {
//        return new LoggingControllerInterceptor();
//    }
//
//    @Bean
//    public UserControllerInterceptor userControllerInterceptor() {
//        return new UserControllerInterceptor();
//    }
//}
