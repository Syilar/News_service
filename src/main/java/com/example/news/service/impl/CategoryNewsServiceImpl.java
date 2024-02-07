//package com.example.news.service.impl;
//
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.model.CategoryNews;
//import com.example.news.repository.CategoryNewsRepository;
//import com.example.news.service.CategoryNewsService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.text.MessageFormat;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CategoryNewsServiceImpl implements CategoryNewsService {
//
//    private final CategoryNewsRepository categoryNewsRepository;
//
//    @Override
//    public List<CategoryNews> findAll() {
//        return categoryNewsRepository.findAll();
//    }
//
//    @Override
//    public CategoryNews findById(Long categoryNewsId) {
//        return categoryNewsRepository.findById(categoryNewsId).orElseThrow(() -> new EntityNotFoundException(
//                MessageFormat.format("Категория новостей с таким ID {0} не найдена!", categoryNewsId)));
//    }
//
//    @Override
//    public CategoryNews createCategoryNews(CategoryNews categoryNews) {
//        return categoryNewsRepository.createCategoryNews(categoryNews);
//    }
//
//    @Override
//    public CategoryNews updateCategoryNews(CategoryNews categoryNews) {
//        return categoryNewsRepository.updateCategoryNews(categoryNews);
//    }
//
//    @Override
//    public void deleteCategoryNews(Long categoryNewsId) {
//        categoryNewsRepository.deleteCategoryNews(categoryNewsId);
//    }
//}
