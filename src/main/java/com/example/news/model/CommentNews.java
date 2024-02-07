package com.example.news.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity(name = "comment_news")
public class CommentNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @CreationTimestamp
    private Instant CreateAt;

    @UpdateTimestamp
    private Instant UpdateAt;

    @ManyToOne
    @JoinColumn(name = "news_id")
    @ToString.Exclude
    private News news;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}
