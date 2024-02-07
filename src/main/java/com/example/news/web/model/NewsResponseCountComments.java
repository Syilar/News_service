package com.example.news.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponseCountComments {
    private Long id;

    private String title;

    private String content;

    private Long categoryNewsId;

    private int countComments;
}
