//package com.example.news.web.filter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@ConditionalOnExpression("${app.check-user-api-header:true}")
//public class UserApiFilterChecker extends OncePerRequestFilter {
//
//    private static final String HTTP_USER_HEADER = "X-User-Api-Key";
//
//    @Value("${app.user-api-key}")
//    private String userApiKey;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String headerValue = request.getHeader(HTTP_USER_HEADER);
//
//        if (headerValue == null || !headerValue.equals(userApiKey)) {
//            response.setHeader(HTTP_USER_HEADER, "Invalid");
//            response.sendError(HttpStatus.BAD_GATEWAY.value(), "Заголовок X-User-Api-Key отсутствует или указан не верно!");
//            return;
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
