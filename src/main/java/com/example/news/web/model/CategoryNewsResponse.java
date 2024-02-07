package com.example.news.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryNewsResponse {

    private Long id;

    private String title;

    private String description;

    private List<NewsResponse> listNews = new ArrayList<>();
}
