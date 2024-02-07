//package com.example.news.mapper.v1;
//
//import com.example.news.model.User;
//import com.example.news.web.model.UpsertUserRequest;
//import com.example.news.web.model.UserListResponse;
//import com.example.news.web.model.UserResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class UserMapper {
//
//    private final NewsMapper newsMapper;
//
//    public User requestToUser(UpsertUserRequest request) {
//        User user = new User();
//
//        user.setName(request.getName());
//        user.setSurname(request.getSurname());
//        user.setEmail(request.getEmail());
//
//        return user;
//    }
//
//    public User requestToUser(Long userId, UpsertUserRequest request) {
//        User user = requestToUser(request);
//
//        user.setId(userId);
//
//        return user;
//    }
//
//    public UserResponse userToResponse(User user) {
//        UserResponse userResponse = new UserResponse();
//
//        userResponse.setId(user.getId());
//        userResponse.setName(user.getName());
//        userResponse.setSurname(user.getSurname());
//        userResponse.setEmail(user.getEmail());
//        userResponse.setListNews(newsMapper.newsListToResponseList(user.getListNews()));
//
//        return userResponse;
//    }
//
//    public UserListResponse userListToUserResponseList(List<User> users) {
//        UserListResponse userListResponse = new UserListResponse();
//
//        userListResponse.setUsers(users.stream().map(this::userToResponse).collect(Collectors.toList()));
//
//        return userListResponse;
//    }
//}
