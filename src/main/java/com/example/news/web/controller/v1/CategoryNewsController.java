//package com.example.news.web.controller.v1;
//
//import com.example.news.mapper.v1.CategoryNewsMapper;
//import com.example.news.model.CategoryNews;
//import com.example.news.service.CategoryNewsService;
//import com.example.news.web.model.CategoryNewsListResponse;
//import com.example.news.web.model.CategoryNewsResponse;
//import com.example.news.web.model.UpsertCategoryNewsRequest;
//import com.example.news.web.model.UpsertNewsRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/categoryNews")
//@RequiredArgsConstructor
//public class CategoryNewsController {
//
//    private final CategoryNewsService categoryNewsService;
//
//    private final CategoryNewsMapper categoryNewsMapper;
//
//    @GetMapping
//    public ResponseEntity<CategoryNewsListResponse> findAll() {
//        return ResponseEntity.ok(
//                categoryNewsMapper.CategoryNewsListToCategoryNewsResponseList(categoryNewsService.findAll()));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CategoryNewsResponse> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(categoryNewsMapper.CategoryNewsToResponse(categoryNewsService.findById(id)));
//    }
//
//    @PostMapping
//    public ResponseEntity<CategoryNewsResponse> create(@RequestBody UpsertCategoryNewsRequest request) {
//        CategoryNews newCategoryNews = categoryNewsService.createCategoryNews(
//                categoryNewsMapper.requestToCategoryNews(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(
//                categoryNewsMapper.CategoryNewsToResponse(newCategoryNews));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CategoryNewsResponse> update(@PathVariable("id") Long categoryId,
//                                                       @RequestBody UpsertCategoryNewsRequest request) {
//        CategoryNews updatedCategoryNews = categoryNewsService.updateCategoryNews(
//                categoryNewsMapper.requestToCategoryNews(categoryId, request));
//
//        return ResponseEntity.ok(categoryNewsMapper.CategoryNewsToResponse(updatedCategoryNews));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        categoryNewsService.deleteCategoryNews(id);
//
//        return ResponseEntity.noContent().build();
//    }
//}
