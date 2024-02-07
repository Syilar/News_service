package com.example.news.web.model;

import com.example.news.validation.NewsFilterValid;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@NewsFilterValid
public class NewsFilter {

    private Integer pageSize;

    private Integer pageNumber;

    private String titleName;

    private Instant createdBefore;

    private Instant updatedBefore;

    private Long userId;

    private String titleCategory;

    private String authorName;
}
