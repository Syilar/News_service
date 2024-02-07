package com.example.news.mapper.v2;

import com.example.news.model.CategoryNews;
import com.example.news.web.model.UpsertCategoryNewsRequest;

public abstract class CategoryNewsMapperDelegate implements CategoryNewsMapperV2 {

    @Override
    public CategoryNews requestToCategoryNews(UpsertCategoryNewsRequest request) {
        CategoryNews categoryNews = new CategoryNews();
        categoryNews.setTitle(request.getTitle());
        categoryNews.setDescription(request.getDescription());

        return categoryNews;
    }

    @Override
    public CategoryNews requestToCategoryNews(Long categoryId, UpsertCategoryNewsRequest request) {
        CategoryNews categoryNews = requestToCategoryNews(request);
        categoryNews.setId(categoryId);
        return categoryNews;
    }
}
