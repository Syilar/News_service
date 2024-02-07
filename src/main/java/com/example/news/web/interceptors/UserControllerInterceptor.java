//package com.example.news.web.interceptors;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Slf4j
//public class UserControllerInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("UserControllerInterceptor -> Подготовка к отправке запроса в UserController");
//        return HandlerInterceptor.super.preHandle(request, response, handler);
//    }
//}
