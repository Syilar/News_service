package com.example.news.mapper.v2;

import com.example.news.model.CommentNews;
import com.example.news.service.NewsService;
import com.example.news.service.UserService;
import com.example.news.web.model.UpsertCommentNewsRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommentNewsMapperDelegate implements CommentNewsMapperV2 {

    @Autowired
    private NewsService databaseNewsService;

    @Autowired
    private UserService databaseUserService;

    @Override
    public CommentNews requestToCommentNews(UpsertCommentNewsRequest request) {
        CommentNews commentNews = new CommentNews();
        commentNews.setComment(request.getComment());
        commentNews.setNews(databaseNewsService.findById(request.getNewsId()));
        commentNews.setUser(databaseUserService.findById(request.getUserId()));

        return commentNews;
    }

    @Override
    public CommentNews requestToCommentNews(Long commentNewsId, UpsertCommentNewsRequest request) {
        CommentNews commentNews = requestToCommentNews(request);
        commentNews.setId(commentNewsId);

        return commentNews;
    }
}
