package com.example.news.service.impl;

import com.example.news.aop.CheckOwnerNews;
import com.example.news.exception.EntityNotFoundException;
import com.example.news.model.CategoryNews;
import com.example.news.model.News;
import com.example.news.model.User;
import com.example.news.repository.DatabaseNewsRepository;
import com.example.news.repository.NewsSpecification;
import com.example.news.service.CategoryNewsService;
import com.example.news.service.NewsService;
import com.example.news.service.UserService;
import com.example.news.utils.BeanUtils;
import com.example.news.web.model.NewsFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseNewsService implements NewsService {

    private final DatabaseNewsRepository newsRepository;

    private final UserService databaseUserService;

    private final CategoryNewsService databaseCategoryNewsService;

    @Override
    public List<News> filterBy(NewsFilter filter) {
        return newsRepository.findAll(NewsSpecification.withFilter(filter),
                PageRequest.of(filter.getPageNumber(), filter.getPageSize()
                )).getContent();
    }

    @Override
    public List<News> findAll(NewsFilter filter) {
        return newsRepository.findAll(PageRequest.of(
                filter.getPageNumber(), filter.getPageSize()
        )).getContent();
    }

    @Override
    public News findById(Long newsId) {
        return newsRepository.findById(newsId).orElseThrow(
                () -> new EntityNotFoundException(
                        MessageFormat.format("Новость с таким ID {} не найдена", newsId)));
    }

    @Override
    public News createNews(News news) {
        User user = databaseUserService.findById(news.getUser().getId());
        CategoryNews categoryNews = databaseCategoryNewsService.findById(news.getCategoryNews().getId());
        news.setUser(user);
        news.setCategoryNews(categoryNews);
        return newsRepository.save(news);
    }

    @Override
    @CheckOwnerNews
    @Transactional
    public News updateNews(News news) {
        User user = databaseUserService.findById(news.getUser().getId());
        CategoryNews categoryNews = databaseCategoryNewsService.findById(news.getCategoryNews().getId());
        News existedNews = findById(news.getId());

        BeanUtils.copyNonNullProperties(news, existedNews);
        existedNews.setUser(user);
        existedNews.setCategoryNews(categoryNews);
        return newsRepository.save(existedNews);
    }

    @Override
    @CheckOwnerNews
    public void deleteById(Long newsId) {
        newsRepository.deleteById(newsId);
    }

    @Override
    public void deleteByIdIn(List<Long> ids) {
        newsRepository.deleteAllById(ids);
    }
}
