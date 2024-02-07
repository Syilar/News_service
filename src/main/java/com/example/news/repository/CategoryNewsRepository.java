package com.example.news.repository;

import com.example.news.model.CategoryNews;

import java.util.List;
import java.util.Optional;

public interface CategoryNewsRepository {
    List<CategoryNews> findAll();

    Optional<CategoryNews> findById(Long categoryNewsId);

    CategoryNews createCategoryNews(CategoryNews categoryNews);

    CategoryNews updateCategoryNews(CategoryNews categoryNews);

    void deleteCategoryNews(Long categoryNewsId);
}
