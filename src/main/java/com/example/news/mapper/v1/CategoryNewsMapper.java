//package com.example.news.mapper.v1;
//
//import com.example.news.model.CategoryNews;
//import com.example.news.web.model.CategoryNewsListResponse;
//import com.example.news.web.model.CategoryNewsResponse;
//import com.example.news.web.model.UpsertCategoryNewsRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class CategoryNewsMapper {
//
//    private final NewsMapper newsMapper;
//
//    public CategoryNews requestToCategoryNews(UpsertCategoryNewsRequest request) {
//        CategoryNews categoryNews = new CategoryNews();
//
//        categoryNews.setTitle(request.getTitle());
//        categoryNews.setDescription(request.getDescription());
//
//        return categoryNews;
//    }
//
//    public CategoryNews requestToCategoryNews(Long categoryId, UpsertCategoryNewsRequest request) {
//        CategoryNews categoryNews = requestToCategoryNews(request);
//
//        categoryNews.setId(categoryId);
//
//        return categoryNews;
//    }
//
//    public CategoryNewsResponse CategoryNewsToResponse(CategoryNews categoryNews) {
//        CategoryNewsResponse response = new CategoryNewsResponse();
//
//        response.setId(categoryNews.getId());
//        response.setTitle(categoryNews.getTitle());
//        response.setDescription(categoryNews.getDescription());
//        response.setListNews(newsMapper.newsListToResponseList(categoryNews.getNewsList()));
//
//        return response;
//    }
//
//    public CategoryNewsListResponse CategoryNewsListToCategoryNewsResponseList(List<CategoryNews> categories) {
//        CategoryNewsListResponse listResponse = new CategoryNewsListResponse();
//
//        listResponse.setCategoriesNews(categories.stream().map(this::CategoryNewsToResponse).collect(Collectors.toList()));
//
//        return listResponse;
//    }
//}
