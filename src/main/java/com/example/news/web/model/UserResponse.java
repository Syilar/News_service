package com.example.news.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private List<NewsResponse> listNews = new ArrayList<>();

    private List<CommentNewsResponse> listComments = new ArrayList<>();
}
