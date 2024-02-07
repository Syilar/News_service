package com.example.news.repository;

import com.example.news.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional<User> findById(Long userId);

    User createUser(User user);

    User updateUser(User user);

    void deleteById(Long userId);
}
