package com.example.news.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_news_id")
    @ToString.Exclude
    private CategoryNews categoryNews;

    @CreationTimestamp
    private Instant createAt;

    @UpdateTimestamp
    private Instant updateAt;

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<CommentNews> listComments = new ArrayList<>();

    public void addComment(CommentNews commentNews) {
        listComments.add(commentNews);
    }

    public void removeComment(Long commentId) {
        listComments = listComments.stream().filter(c -> !c.getId().equals(commentId)).collect(Collectors.toList());
    }
}
