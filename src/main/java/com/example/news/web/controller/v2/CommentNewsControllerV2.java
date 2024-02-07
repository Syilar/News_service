package com.example.news.web.controller.v2;

import com.example.news.mapper.v2.CommentNewsMapperV2;
import com.example.news.model.CommentNews;
import com.example.news.service.CommentNewsService;
import com.example.news.web.model.CommentNewsListResponse;
import com.example.news.web.model.CommentNewsResponse;
import com.example.news.web.model.UpsertCommentNewsRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/commentNews")
public class CommentNewsControllerV2 {

    private final CommentNewsService databaseCommentNewsService;

    private final CommentNewsMapperV2 commentNewsMapper;

    @GetMapping
    public ResponseEntity<CommentNewsListResponse> findAll() {
        return ResponseEntity.ok(commentNewsMapper.commentNewsListToCommentNewsListResponse(
                databaseCommentNewsService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentNewsResponse> findById(@PathVariable("id") Long commentId) {
        return ResponseEntity.ok(commentNewsMapper.commentNewsToResponse(databaseCommentNewsService.findById(commentId)));
    }

    @PostMapping
    public ResponseEntity<CommentNewsResponse> create(@RequestBody @Valid UpsertCommentNewsRequest request) {
        CommentNews commentNews = databaseCommentNewsService.createCommentNews(
                commentNewsMapper.requestToCommentNews(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(commentNewsMapper.commentNewsToResponse(commentNews));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentNewsResponse> update(@PathVariable("id") Long commentId,
                                                      @RequestBody @Valid UpsertCommentNewsRequest request) {
        CommentNews updatedComment = databaseCommentNewsService.updateCommentNews(
                commentNewsMapper.requestToCommentNews(commentId, request));

        return ResponseEntity.ok(commentNewsMapper.commentNewsToResponse(updatedComment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        databaseCommentNewsService.deleteCommentNewsById(id);

        return ResponseEntity.noContent().build();
    }
}
