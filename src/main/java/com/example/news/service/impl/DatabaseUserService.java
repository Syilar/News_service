package com.example.news.service.impl;

import com.example.news.exception.EntityNotFoundException;
import com.example.news.model.News;
import com.example.news.model.User;
import com.example.news.repository.DatabaseNewsRepository;
import com.example.news.repository.DatabaseUserRepository;
import com.example.news.service.UserService;
import com.example.news.utils.BeanUtils;
import com.example.news.web.model.UserFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseUserService implements UserService {

    private final DatabaseUserRepository userRepository;

    private final DatabaseNewsRepository newsRepository;

    @Override
    public List<User> findAll(UserFilter filter) {
        return userRepository.findAll(PageRequest.of(
                filter.getPageNumber(), filter.getPageSize()
        )).getContent();
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException(
                        MessageFormat.format("Пользователь с таким ID {} не найден!", userId)));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User existedUser = findById(user.getId());

        BeanUtils.copyNonNullProperties(user, existedUser);
        return userRepository.save(existedUser);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    @Transactional
    public User saveWithNews(User user, List<News> listNews) {
        User savedUser = userRepository.save(user);

        for (News news : listNews) {
            news.setUser(savedUser);
            newsRepository.save(news);
            savedUser.addNews(news);
        }

        return savedUser;
    }
}
