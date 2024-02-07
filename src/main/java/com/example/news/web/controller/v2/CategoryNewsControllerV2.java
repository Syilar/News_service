package com.example.news.web.controller.v2;

import com.example.news.mapper.v2.CategoryNewsMapperV2;
import com.example.news.model.CategoryNews;
import com.example.news.service.CategoryNewsService;
import com.example.news.web.model.CategoryNewsFilter;
import com.example.news.web.model.CategoryNewsListResponse;
import com.example.news.web.model.CategoryNewsResponse;
import com.example.news.web.model.UpsertCategoryNewsRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/categoryNews")
@RequiredArgsConstructor
public class CategoryNewsControllerV2 {

    private final CategoryNewsService databaseCategoryNewsService;

    private final com.example.news.mapper.v2.CategoryNewsMapperV2 categoryNewsMapperV2;

    @GetMapping
    public ResponseEntity<CategoryNewsListResponse> findAll(@Valid CategoryNewsFilter filter) {
        return ResponseEntity.ok(categoryNewsMapperV2.categoryNewsListToCategoryNewsListResponse(
                databaseCategoryNewsService.findAll(filter)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryNewsResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryNewsMapperV2.categoryNewsToResponse(databaseCategoryNewsService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CategoryNewsResponse> create(@RequestBody @Valid UpsertCategoryNewsRequest request) {
        CategoryNews categoryNews = databaseCategoryNewsService.createCategoryNews(
                categoryNewsMapperV2.requestToCategoryNews(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryNewsMapperV2.categoryNewsToResponse(categoryNews));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryNewsResponse> update(@PathVariable("id") Long categoryId,
                                                       @RequestBody @Valid UpsertCategoryNewsRequest request) {
        CategoryNews categoryNews = databaseCategoryNewsService.updateCategoryNews(
                categoryNewsMapperV2.requestToCategoryNews(categoryId, request));

        return ResponseEntity.ok(categoryNewsMapperV2.categoryNewsToResponse(categoryNews));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        databaseCategoryNewsService.deleteCategoryNews(id);

        return ResponseEntity.noContent().build();
    }
}
