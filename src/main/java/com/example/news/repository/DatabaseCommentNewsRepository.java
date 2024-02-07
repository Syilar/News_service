package com.example.news.repository;

import com.example.news.model.CommentNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseCommentNewsRepository extends JpaRepository<CommentNews, Long> {

}
