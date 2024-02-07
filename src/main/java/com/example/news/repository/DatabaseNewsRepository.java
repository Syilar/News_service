package com.example.news.repository;

import com.example.news.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DatabaseNewsRepository extends JpaRepository<News, Long>, JpaSpecificationExecutor<News> {

    @Override
//    @EntityGraph(attributePaths = {"listComments"})
    Page<News> findAll(Pageable pageable);
}
