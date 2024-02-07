package com.example.news.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserWithNewsRequest {

    private String name;

    private String Surname;

    private String email;

    private List<NewsRequest> listNews;
}
