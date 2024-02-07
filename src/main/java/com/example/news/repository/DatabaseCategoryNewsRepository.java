package com.example.news.repository;

import com.example.news.model.CategoryNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DatabaseCategoryNewsRepository extends JpaRepository<CategoryNews, Long>,
        JpaSpecificationExecutor<CategoryNews> {

    @Override
    Page<CategoryNews> findAll(Pageable pageable);
}
