package com.example.news.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseCountComments {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private List<NewsResponseCountComments> listNews = new ArrayList<>();

    private List<CommentNewsResponse> listComments = new ArrayList<>();
}
