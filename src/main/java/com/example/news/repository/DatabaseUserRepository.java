package com.example.news.repository;

import com.example.news.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DatabaseUserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Override
//    @EntityGraph(attributePaths = {"listNews", "listNews.listComments"})
    Page<User> findAll(Pageable pageable);
}
