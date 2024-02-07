package com.example.news.service;

import com.example.news.model.CategoryNews;
import com.example.news.web.model.CategoryNewsFilter;

import java.util.List;

public interface CategoryNewsService {

    List<CategoryNews> findAll(CategoryNewsFilter filter);

    CategoryNews findById(Long categoryNewsId);

    CategoryNews createCategoryNews(CategoryNews categoryNews);

    CategoryNews updateCategoryNews(CategoryNews categoryNews);

    void deleteCategoryNews(Long categoryNewsId);
}
