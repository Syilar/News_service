//package com.example.news.web.controller.v1;
//
//import com.example.news.mapper.v1.CommentNewsMapper;
//import com.example.news.model.CommentNews;
//import com.example.news.service.CommentNewsService;
//import com.example.news.web.model.CommentNewsListResponse;
//import com.example.news.web.model.CommentNewsResponse;
//import com.example.news.web.model.UpsertCommentNewsRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/api/v1/commentNews")
//@RequiredArgsConstructor
//public class CommentNewsController {
//
//    private final CommentNewsService commentNewsService;
//
//    private final CommentNewsMapper commentNewsMapper;
//
//    @GetMapping
//    public ResponseEntity<CommentNewsListResponse> findAll() {
//        return ResponseEntity.ok(commentNewsMapper.commentNewsListToCommentNewsListResponse(
//                commentNewsService.findAll()));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CommentNewsResponse> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(commentNewsMapper.commentNewsToResponse(commentNewsService.findById(id)));
//    }
//
//    @PostMapping
//    public ResponseEntity<CommentNewsResponse> create(@RequestBody UpsertCommentNewsRequest request) {
//        CommentNews newCommentNews = commentNewsService.createCommentNews(
//                commentNewsMapper.requestToCommentNews(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(commentNewsMapper.commentNewsToResponse(newCommentNews));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CommentNewsResponse> update(@PathVariable("id") Long commentId,
//                                                      @RequestBody UpsertCommentNewsRequest request) {
//        CommentNews updatedCommentNews = commentNewsService.updateCommentNews(
//                commentNewsMapper.requestToCommentNews(commentId, request));
//
//        return ResponseEntity.ok(commentNewsMapper.commentNewsToResponse(updatedCommentNews));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        commentNewsService.deleteCommentNewsById(id);
//
//        return ResponseEntity.noContent().build();
//    }
//}
