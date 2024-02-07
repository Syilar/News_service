package com.example.news.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryNewsListResponse {

    List<CategoryNewsResponse> categoriesNews = new ArrayList<>();
}
