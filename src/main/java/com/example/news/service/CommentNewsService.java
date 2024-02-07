package com.example.news.service;

import com.example.news.model.CommentNews;

import java.util.List;

public interface CommentNewsService {

    List<CommentNews> findAll();

    CommentNews findById(Long commentNewsId);

    List<CommentNews> findByNewsId(Long newsId);

    CommentNews createCommentNews(CommentNews commentNews);

    CommentNews updateCommentNews(CommentNews commentNews);

    void deleteCommentNewsById(Long commentNewsId);

    void deleteCommentNewsByIdIn(List<Long> ids);
}
