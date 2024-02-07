package com.example.news.web.controller.v2;

import com.example.news.mapper.v2.UserMapperV2;
import com.example.news.model.News;
import com.example.news.model.User;
import com.example.news.service.UserService;
import com.example.news.web.model.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/user")
@RequiredArgsConstructor
public class UserControllerV2 {

    private final UserService databaseUserService;

    private final UserMapperV2 userMapper;

    @GetMapping
    public ResponseEntity<UserListResponse> findAll(@Valid UserFilter filter) {
        return ResponseEntity.ok(userMapper.userListToUserListResponse(databaseUserService.findAll(filter)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userMapper.userToResponse(databaseUserService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UpsertUserRequest request) {
        User user = databaseUserService.createUser(userMapper.requestToUser(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.userToResponse(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable("id") Long userId, @RequestBody @Valid UpsertUserRequest request) {
        User updetedUser = databaseUserService.update(userMapper.requestToUser(userId, request));

        return ResponseEntity.ok(userMapper.userToResponse(updetedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long userId) {
        databaseUserService.deleteById(userId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("save-with-news")
    public ResponseEntity<UserResponse> createWithNews(@RequestBody CreateUserWithNewsRequest request) {
        User user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail()).build();

        List<News> listNews = request.getListNews().stream()
                .map(newsRequest -> News.builder()
                .title(newsRequest.getTitle())
                .content(newsRequest.getContent())
                .build()).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.userToResponse(databaseUserService.saveWithNews(user, listNews)));
    }
}
