package com.example.news.repository;

import com.example.news.model.News;

import java.util.List;
import java.util.Optional;

public interface NewsRepository {

    List<News> findAll();

    Optional<News> findById(Long newsId);

    News createNews(News news);

    News updateNews(News news);

    void deleteById(Long newsId);

    void deleteByIdIn(List<Long> ids);

    void updateNewsCategoryNull(List<News> newsList);
}
