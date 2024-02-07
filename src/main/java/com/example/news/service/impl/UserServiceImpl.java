//package com.example.news.service.impl;
//
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.model.User;
//import com.example.news.repository.UserRepository;
//import com.example.news.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.text.MessageFormat;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User findById(Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new EntityNotFoundException(MessageFormat
//                        .format("Пользователь с ID {0} не найден!", userId)));
//    }
//
//    @Override
//    public User createUser(User user) {
//        return userRepository.createUser(user);
//    }
//
//    @Override
//    public User update(User user) {
//        return userRepository.updateUser(user);
//    }
//
//    @Override
//    public void deleteById(Long userId) {
//        userRepository.deleteById(userId);
//    }
//}
