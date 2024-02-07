package com.example.news;

import com.example.news.model.CategoryNews;
import com.example.news.model.CommentNews;
import com.example.news.model.News;
import com.example.news.model.User;
import com.example.news.web.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public abstract class AbstractTestController {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected User createUser(Long id, News news) {
        User user = new User(id,
                "User " + id,
                "Surname " + id,
                id + "@email.com",
                new ArrayList<>(),
                new ArrayList<>());

        if (news != null) {
            news.setUser(user);
            user.addNews(news);
        }

        return user;
    }

    protected News createNews(Long id, User user, CategoryNews categoryNews, CommentNews commentNews) {
        News news = new News(id,
                "Title " + id,
                "content " + id,
                user,
                categoryNews,
                Instant.now(),
                Instant.now(),
                new ArrayList<>());

        if (categoryNews != null) {
            categoryNews.addNews(news);
        }
        if (commentNews != null) {
            commentNews.setNews(news);
            news.addComment(commentNews);
        }

        return news;
    }

    protected CategoryNews createCategoryNews(Long id) {
        return new CategoryNews(id,
                "Title " + id,
                "description " + id,
                new ArrayList<>());
    }

    protected CommentNews createCommentNews(Long id, News news, User user) {
        CommentNews commentNews = new CommentNews(id,
                "comment " + id,
                Instant.now(),
                Instant.now(),
                news,
                user);

        if (news != null) {
            commentNews.setNews(news);
            news.addComment(commentNews);

        }

        return commentNews;
    }

    protected UserResponseCountComments createUserResponse(Long id, NewsResponseCountComments newsResponse) {
        UserResponseCountComments userResponseCountComments = new UserResponseCountComments(id,
                "Name " + id,
                "Surname " + id,
                id + "@email.com",
                new ArrayList<>(),
                new ArrayList<>());

        if (newsResponse != null) {
            userResponseCountComments.getListNews().add(newsResponse);
        }

        return userResponseCountComments;
    }

    protected NewsResponse createNewsResponse(Long id, Long categoryId, CommentNewsResponse commentNewsResponse) {
         NewsResponse newsResponse = new NewsResponse(id,
                "Title " + id,
                "content " + id,
                categoryId,
                new ArrayList<>());
        if (commentNewsResponse != null) {
            newsResponse.getListComments().add(commentNewsResponse);
        }

        return newsResponse;
    }

    protected CategoryNewsResponse createCategoryNewsResponse(Long id) {
        return new CategoryNewsResponse(id,
                "Title " + id,
                "description " + id,
                new ArrayList<>());
    }

    protected CommentNewsResponse createCommentNewsResponse(Long id, Long userId, Long newsId, NewsResponse newsResponse) {
        CommentNewsResponse commentNewsResponse = new CommentNewsResponse(id,
                "comment " + id,
                userId,
                newsId);

        if (newsResponse != null) {

            newsResponse.getListComments().add(commentNewsResponse);
        }

        return commentNewsResponse;
    }
}
