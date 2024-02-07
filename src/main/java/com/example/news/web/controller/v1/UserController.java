//package com.example.news.web.controller.v1;
//
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.mapper.v1.UserMapper;
//import com.example.news.model.User;
//import com.example.news.service.UserService;
//import com.example.news.web.model.UpsertUserRequest;
//import com.example.news.web.model.UserListResponse;
//import com.example.news.web.model.UserResponse;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/user")
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//    private final UserMapper userMapper;
//
//    @GetMapping
//    public ResponseEntity<UserListResponse> findAll() {
//        return ResponseEntity.ok(userMapper.userListToUserResponseList(userService.findAll()));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(userMapper.userToResponse(userService.findById(id)));
//    }
//
//    @PostMapping
//    public ResponseEntity<UserResponse> create(@RequestBody @Valid UpsertUserRequest request) {
//        User newUser = userService.createUser(userMapper.requestToUser(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.userToResponse(newUser));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserResponse> update(@PathVariable("id") Long userId, @RequestBody UpsertUserRequest request) {
//        User updatedUser = userService.update(userMapper.requestToUser(userId, request));
//
//        return ResponseEntity.ok(userMapper.userToResponse(updatedUser));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        userService.deleteById(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<Void> notFoundHandler(EntityNotFoundException ex) {
//        return ResponseEntity.notFound().build();
//    }
//}
