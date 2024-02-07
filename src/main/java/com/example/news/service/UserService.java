package com.example.news.service;

import com.example.news.model.News;
import com.example.news.model.User;
import com.example.news.web.model.UserFilter;

import java.util.List;

public interface UserService {

    List<User> findAll(UserFilter filter);

    User findById(Long userId);

    User createUser(User user);

    User update(User user);

    void deleteById(Long userId);

    User saveWithNews(User user, List<News> listNews);
}
