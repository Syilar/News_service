package com.example.news.repository;

import com.example.news.model.CommentNews;

import java.util.List;
import java.util.Optional;

public interface CommentNewsRepository {
    List<CommentNews> findAll();

    Optional<CommentNews> findById(Long commentNewsId);

    List<CommentNews> findByNewsId(Long newsId);

    CommentNews createCommentNews(CommentNews commentNews);

    CommentNews updateCommentNews(CommentNews commentNews);

    void deleteCommentNewsById(Long commentNewsId);

    void deleteCommentNewsByIdIn(List<Long> ids);
}
