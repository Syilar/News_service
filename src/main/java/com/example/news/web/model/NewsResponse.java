package com.example.news.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {

    private Long id;

    private String title;

    private String content;

    private Long categoryNewsId;

    private List<CommentNewsResponse> listComments = new ArrayList<>();
}
