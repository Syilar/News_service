package com.example.news.mapper.v2;

import com.example.news.model.CategoryNews;
import com.example.news.web.model.CategoryNewsListResponse;
import com.example.news.web.model.CategoryNewsResponse;
import com.example.news.web.model.UpsertCategoryNewsRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@DecoratedWith(CategoryNewsMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = NewsMapperV2.class)
public interface CategoryNewsMapperV2 {

    CategoryNews requestToCategoryNews(UpsertCategoryNewsRequest request);

    @Mapping(source = "categoryId", target = "id")
    CategoryNews requestToCategoryNews(Long categoryId, UpsertCategoryNewsRequest request);

    CategoryNewsResponse categoryNewsToResponse(CategoryNews categoryNews);

    default CategoryNewsListResponse categoryNewsListToCategoryNewsListResponse(List<CategoryNews> categories) {
        CategoryNewsListResponse response = new CategoryNewsListResponse();

        response.setCategoriesNews(categories.stream()
        .map(this::categoryNewsToResponse).collect(Collectors.toList()));

        return response;
    }


}
