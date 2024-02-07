package com.example.news.aop;

import com.example.news.exception.WrongUserException;
import com.example.news.service.CommentNewsService;
import com.example.news.service.NewsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class CheckingAspect {

    private final NewsService databaseNewsService;

    private final CommentNewsService databaseCommentNewsService;

    @Before("@annotation(CheckOwnerNews)")
    public void checkBeforeNews(JoinPoint joinPoint) {
        if (joinPoint.getSignature().getName().equals("findById")) {
            return;
        }

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        var pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Long newsId = Long.valueOf(pathVariables.get("id"));
        Long userId = databaseNewsService.findById(newsId).getUser().getId();

        Long userIdReq = null;
        try {
            userIdReq = Long.valueOf(request.getParameter("userId"));
        } catch (NumberFormatException e) {
            log.warn("Некорректно указан параметр userId! userId не должен быть null!");
            throw new WrongUserException("Некорректно указан параметр userId! userId не должен быть null!");
        }


        if (!userId.equals(userIdReq)) {
            log.warn("Пользователь с ID {} не может редактировать новость. Эту новость создал пользователь с ID {}",
                    userIdReq, userId);
            throw new WrongUserException("У этого пользователя нет прав доступа для редактирования этой новости!");
        }
        log.info("{} is done.", joinPoint.getSignature().getName());
    }

    @Before("@annotation(CheckOwnerComment)")
    public void checkBeforeComment(JoinPoint joinPoint) {
        if (joinPoint.getSignature().getName().equals("findById")) {
            return;
        }

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        var pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Long commentId = Long.valueOf(pathVariables.get("id"));
        Long userId = databaseCommentNewsService.findById(commentId).getUser().getId();

        Long userIdReq = null;
        try {
            userIdReq = Long.valueOf(request.getParameter("userId"));
        } catch (NumberFormatException e) {
            log.warn("Некорректно указан параметр userId! userId не должен быть null!");
            throw new WrongUserException("Некорректно указан параметр userId! userId не должен быть null!");
        }

        if (!userId.equals(userIdReq)) {
            log.warn("Пользователь с ID {} не может редактировать  этот комментарий." +
                            "Этот комментарий создал пользователь с ID {}",
                    userIdReq, userId);
            throw new WrongUserException("У этого пользователя нет прав доступа для редактирования этого комментария!");
        }
        log.info("{} is done.", joinPoint.getSignature().getName());
    }
}
