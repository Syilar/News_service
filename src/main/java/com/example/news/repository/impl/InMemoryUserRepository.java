//package com.example.news.repository.impl;
//
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.model.News;
//import com.example.news.model.User;
//import com.example.news.repository.NewsRepository;
//import com.example.news.repository.UserRepository;
//import com.example.news.utils.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicLong;
//import java.util.stream.Collectors;
//
//@Component
//public class InMemoryUserRepository implements UserRepository {
//
//    private NewsRepository newsRepository;
//
//    private final Map<Long, User> repository = new ConcurrentHashMap<>();
//
//    private final AtomicLong currentId = new AtomicLong(1);
//
//    @Autowired
//    public void setNewsRepository(NewsRepository newsRepository) {
//        this.newsRepository = newsRepository;
//    }
//
//    @Override
//    public List<User> findAll() {
//        return new ArrayList<>(repository.values());
//    }
//
//    @Override
//    public Optional<User> findById(Long userId) {
//        return Optional.ofNullable(repository.get(userId));
//    }
//
//    @Override
//    public User createUser(User user) {
//        Long userId = currentId.getAndIncrement();
//        user.setId(userId);
//
//        repository.put(userId,user);
//
//        return user;
//    }
//
//    @Override
//    public User updateUser(User user) {
//        Long userId = user.getId();
//        User currentUser = repository.get(userId);
//
//        if (currentUser == null) {
//            throw new EntityNotFoundException(MessageFormat.format("Пользователь c ID {0} не найден!", userId));
//        }
//
//        BeanUtils.copyNonNullProperties(user, currentUser);
//        currentUser.setId(userId);
//        repository.put(userId, currentUser);
//
//        return currentUser;
//    }
//
//    @Override
//    public void deleteById(Long userId) {
//        User user = repository.get(userId);
//
//        if (user == null) {
//            throw new EntityNotFoundException(MessageFormat.format("Пользователь c ID {0} не найден!", userId));
//        }
//
//        newsRepository.deleteByIdIn(user.getListNews().stream().map(News::getId).collect(Collectors.toList()));
//        repository.remove(userId);
//    }
//}
