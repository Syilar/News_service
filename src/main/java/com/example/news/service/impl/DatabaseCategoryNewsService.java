package com.example.news.service.impl;

import com.example.news.exception.EntityNotFoundException;
import com.example.news.model.CategoryNews;
import com.example.news.repository.DatabaseCategoryNewsRepository;
import com.example.news.service.CategoryNewsService;
import com.example.news.utils.BeanUtils;
import com.example.news.web.model.CategoryNewsFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseCategoryNewsService implements CategoryNewsService {

    private final DatabaseCategoryNewsRepository databaseCategoryNewsRepository;

    @Override
    public List<CategoryNews> findAll(CategoryNewsFilter filter) {
        return databaseCategoryNewsRepository.findAll(PageRequest.of(
                filter.getPageNumber(), filter.getPageSize()
        )).getContent();
    }

    @Override
    public CategoryNews findById(Long categoryNewsId) {
        return databaseCategoryNewsRepository.findById(categoryNewsId).orElseThrow(
                () -> new EntityNotFoundException(
                        MessageFormat.format("Категория новостей с ID {} не найдена!", categoryNewsId)));
    }

    @Override
    public CategoryNews createCategoryNews(CategoryNews categoryNews) {
        return databaseCategoryNewsRepository.save(categoryNews);
    }

    @Override
    public CategoryNews updateCategoryNews(CategoryNews categoryNews) {
        CategoryNews existedCategory = findById(categoryNews.getId());

        BeanUtils.copyNonNullProperties(categoryNews, existedCategory);
        return databaseCategoryNewsRepository.save(existedCategory);
    }

    @Override
    public void deleteCategoryNews(Long categoryNewsId) {
        databaseCategoryNewsRepository.deleteById(categoryNewsId);
    }
}
