package com.example.news.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity(name = "category_news")
public class CategoryNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title_category")
    private String title;

    @Column(name = "description_category")
    private String description;

    @OneToMany(mappedBy = "categoryNews", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<News> listNews = new ArrayList<>();

    public void addNews(News news) {
        listNews.add(news);
    }

    public void remove(Long newsId) {
        listNews = listNews.stream().filter(n -> !n.getId().equals(newsId)).collect(Collectors.toList());
    }
}
