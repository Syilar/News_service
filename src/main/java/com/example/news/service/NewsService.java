package com.example.news.service;

import com.example.news.model.News;
import com.example.news.web.model.NewsFilter;

import java.util.List;

public interface NewsService {

    List<News> filterBy(NewsFilter filter);

    List<News> findAll(NewsFilter filter);

    News findById(Long newsId);

    News createNews(News news);

    News updateNews(News news);

    void deleteById(Long newsId);

    void deleteByIdIn(List<Long> ids);
}
