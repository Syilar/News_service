//package com.example.news.web.controller.v1;
//
//import com.example.news.mapper.v1.NewsMapper;
//import com.example.news.model.News;
//import com.example.news.service.NewsService;
//import com.example.news.web.model.NewsListResponse;
//import com.example.news.web.model.NewsResponse;
//import com.example.news.web.model.UpsertNewsRequest;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/news")
//public class NewsController {
//
//    private final NewsService newsService;
//
//    private final NewsMapper newsMapper;
//
//    @GetMapping
//    public ResponseEntity<NewsListResponse> findAll() {
//        return ResponseEntity.ok(newsMapper.newsListToNewsListResponse(newsService.findAll()));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NewsResponse> findById(@PathVariable("id") Long newsId) {
//        return ResponseEntity.ok(newsMapper.newsToResponse(newsService.findById(newsId)));
//    }
//
//    @PostMapping
//    public ResponseEntity<NewsResponse> create(@RequestBody @Valid UpsertNewsRequest request) {
//        News newNews = newsService.createNews(newsMapper.requestToNews(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(newsMapper.newsToResponse(newNews));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<NewsResponse> update(@PathVariable("id") Long newsId, @RequestBody UpsertNewsRequest request) {
//        News updatedNews = newsService.updateNews(newsMapper.requestToNews(newsId, request));
//
//        return ResponseEntity.ok(newsMapper.newsToResponse(updatedNews));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//     newsService.deleteById(id);
//
//     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<Void> notFoundHandler(EntityNotFoundException ex) {
//        return ResponseEntity.notFound().build();
//    }
//}
