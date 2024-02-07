//package com.example.news.service.impl;
//
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.model.News;
//import com.example.news.repository.NewsRepository;
//import com.example.news.service.NewsService;
//import com.example.news.web.model.NewsFilter;
//import jdk.jshell.spi.ExecutionControl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.repository.core.support.FragmentNotImplementedException;
//import org.springframework.stereotype.Service;
//
//import java.text.MessageFormat;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class NewsServiceImpl implements NewsService {
//
//    private final NewsRepository newsRepository;
//
//    @Override
//    public List<News> filterBy(NewsFilter filter) {
//        return null;
//    }
//
//    @Override
//    public List<News> findAll() {
//        return newsRepository.findAll();
//    }
//
//    @Override
//    public News findById(Long newsId) {
//        return newsRepository.findById(newsId)
//                .orElseThrow(() -> new EntityNotFoundException(
//                        MessageFormat.format("Новость с таким ID {0} не найдена!", newsId)));
//    }
//
//    @Override
//    public News createNews(News news) {
//        return newsRepository.createNews(news);
//    }
//
//    @Override
//    public News updateNews(News news) {
//        return newsRepository.updateNews(news);
//    }
//
//    @Override
//    public void deleteById(Long newsId) {
//        newsRepository.deleteById(newsId);
//    }
//
//    @Override
//    public void deleteByIdIn(List<Long> ids) {
//        newsRepository.deleteByIdIn(ids);
//    }
//}
