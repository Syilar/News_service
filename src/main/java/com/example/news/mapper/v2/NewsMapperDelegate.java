package com.example.news.mapper.v2;

import com.example.news.model.CommentNews;
import com.example.news.model.News;
import com.example.news.service.CategoryNewsService;
import com.example.news.service.CommentNewsService;
import com.example.news.service.UserService;
import com.example.news.web.model.NewsResponse;
import com.example.news.web.model.NewsResponseCountComments;
import com.example.news.web.model.UpsertNewsRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class NewsMapperDelegate implements NewsMapperV2 {

    @Autowired
    private UserService databaseUserService;

    @Autowired
    private CategoryNewsService databaseCategoryNewsService;

    @Autowired
    private CommentNewsService databaseCommentNewsService;

    @Autowired
    private CommentNewsMapperV2 commentNewsMapperV2;

    @Override
    public News requestToNews(UpsertNewsRequest request) {
        News news = new News();
        news.setTitle(request.getTitle());
        news.setContent(request.getContent());
        news.setUser(databaseUserService.findById(request.getUserId()));
        news.setCategoryNews(databaseCategoryNewsService.findById(request.getCategoryId()));

        return news;
    }

    @Override
    public News requestToNews(Long id, UpsertNewsRequest request) {
        News news = requestToNews(request);
        news.setId(id);
        return news;
    }

    @Override
    public NewsResponse newsToResponse(News news) {
        NewsResponse response = new NewsResponse();
        response.setId(news.getId());
        response.setTitle(news.getTitle());
        response.setContent(news.getContent());
        response.setCategoryNewsId(news.getCategoryNews().getId());
        List<CommentNews> comments = databaseCommentNewsService.findByNewsId(news.getId());
        response.setListComments(commentNewsMapperV2.commentNewsListToResponseList(comments));
        return response;
    }

    @Override
    public NewsResponseCountComments newsToResponseCountComments(News news) {
        NewsResponseCountComments newsResponseCountComments = new NewsResponseCountComments();
        newsResponseCountComments.setId(news.getId());
        newsResponseCountComments.setTitle(news.getTitle());
        newsResponseCountComments.setContent(news.getContent());
        newsResponseCountComments.setCategoryNewsId(news.getCategoryNews().getId());
        List<CommentNews> comments = databaseCommentNewsService.findByNewsId(news.getId());
        newsResponseCountComments.setCountComments(comments.size());
        return newsResponseCountComments;
    }

    @Override
    public List<NewsResponseCountComments> newsListToResponseListCountComments(List<News> news) {
        return news.stream().map(this::newsToResponseCountComments).collect(Collectors.toList());
    }
}
