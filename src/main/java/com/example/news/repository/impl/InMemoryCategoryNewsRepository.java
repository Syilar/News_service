//package com.example.news.repository.impl;
//
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.model.CategoryNews;
//import com.example.news.repository.CategoryNewsRepository;
//import com.example.news.repository.NewsRepository;
//import com.example.news.utils.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicLong;
//import java.util.stream.Collectors;
//
//@Component
//public class InMemoryCategoryNewsRepository implements CategoryNewsRepository {
//
//    private NewsRepository newsRepository;
//
//    private final Map<Long, CategoryNews> repository = new ConcurrentHashMap<>();
//
//    private final AtomicLong currentId = new AtomicLong(1);
//
//    @Autowired
//    public void setNewsRepository(NewsRepository newsRepository) {
//        this.newsRepository = newsRepository;
//    }
//
//    @Override
//    public List<CategoryNews> findAll() {
//        return new ArrayList<>(repository.values());
//    }
//
//    @Override
//    public Optional<CategoryNews> findById(Long categoryNewsId) {
//        return Optional.ofNullable(repository.get(categoryNewsId));
//    }
//
//    @Override
//    public CategoryNews createCategoryNews(CategoryNews categoryNews) {
//        Long categoryNewsId = currentId.getAndIncrement();
//        categoryNews.setId(categoryNewsId);
//
//        repository.put(categoryNewsId, categoryNews);
//        return categoryNews;
//    }
//
//    @Override
//    public CategoryNews updateCategoryNews(CategoryNews categoryNews) {
//        Long categoryNewsId = categoryNews.getId();
//        CategoryNews currentCategoryNews = repository.get(categoryNewsId);
//
//        if (currentCategoryNews == null) {
//            throw new EntityNotFoundException
//                    (MessageFormat.format("Категория новостей с таким ID {0} не найдена", categoryNewsId));
//        }
//
//        BeanUtils.copyNonNullProperties(categoryNews, currentCategoryNews);
//        currentCategoryNews.setId(categoryNewsId);
//        repository.put(categoryNewsId, currentCategoryNews);
//        return currentCategoryNews;
//    }
//
//    @Override
//    public void deleteCategoryNews(Long categoryNewsId) {
//        CategoryNews categoryNews = repository.get(categoryNewsId);
//
//        if (categoryNews == null) {
//            throw new EntityNotFoundException
//                    (MessageFormat.format("Категория новостей с таким ID {0} не найдена", categoryNewsId));
//        }
//
//        newsRepository.updateNewsCategoryNull(categoryNews.getNewsList());
//        repository.remove(categoryNewsId);
//    }
//}
