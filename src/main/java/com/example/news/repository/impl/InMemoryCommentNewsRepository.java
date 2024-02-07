//package com.example.news.repository.impl;
//
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.model.CommentNews;
//import com.example.news.model.News;
//import com.example.news.repository.CommentNewsRepository;
//import com.example.news.repository.NewsRepository;
//import com.example.news.utils.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.text.MessageFormat;
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Component
//public class InMemoryCommentNewsRepository implements CommentNewsRepository {
//
//    private NewsRepository newsRepository;
//
//    private final Map<Long, CommentNews> repository = new ConcurrentHashMap<>();
//
//    AtomicLong currentId = new AtomicLong(1);
//
//    @Autowired
//    public void setNewsRepository(NewsRepository newsRepository) {
//        this.newsRepository = newsRepository;
//    }
//
//    @Override
//    public List<CommentNews> findAll() {
//        return new ArrayList<>(repository.values());
//    }
//
//    @Override
//    public Optional<CommentNews> findById(Long commentNewsId) {
//        return Optional.ofNullable(repository.get(commentNewsId));
//    }
//
//    @Override
//    public List<CommentNews> findByNewsId(Long newsId) {
//        News news = newsRepository.findById(newsId).orElseThrow(() -> new EntityNotFoundException(
//                MessageFormat.format("Новость с таким ID {0} не найдена", newsId)));
//
//        List<CommentNews> currentCommentsNews = news.getCommentNewsList();
//        return currentCommentsNews;
//    }
//
//    @Override
//    public CommentNews createCommentNews(CommentNews commentNews) {
//        Long commentId = currentId.getAndIncrement();
//        Long newsId = commentNews.getNews().getId();
//
//        News news = newsRepository.findById(newsId).orElseThrow(() -> new EntityNotFoundException("Новость не найдена"));
//
//        commentNews.setId(commentId);
//        commentNews.setNews(news);
//        Instant now = Instant.now();
//        commentNews.setCreateAt(now);
//
//        repository.put(commentId, commentNews);
//        news.addComment(commentNews);
//        newsRepository.updateNews(news);
//
//        return commentNews;
//    }
//
//    @Override
//    public CommentNews updateCommentNews(CommentNews commentNews) {
//        Long commentId = commentNews.getId();
//        Instant now = Instant.now();
//        CommentNews currentCommentNews = repository.get(commentId);
//
//        if (currentCommentNews == null) {
//            throw new EntityNotFoundException
//                    (MessageFormat.format("Комментарий с таким ID {0} не найден!", commentId));
//        }
//
//        BeanUtils.copyNonNullProperties(commentNews, currentCommentNews);
//        currentCommentNews.setId(commentId);
//        currentCommentNews.setUpdateAt(now);
//        repository.put(commentId, currentCommentNews);
//
//        return currentCommentNews;
//    }
//
//    @Override
//    public void deleteCommentNewsById(Long commentNewsId) {
//        CommentNews commentNews = repository.get(commentNewsId);
//
//        if (commentNews == null) {
//            throw new EntityNotFoundException(MessageFormat.format("Комментарий c ID {0} не найден!", commentNewsId));
//        }
//
//        commentNews.getNews().removeComment(commentNewsId);
//        repository.remove(commentNewsId);
//    }
//
//    @Override
//    public void deleteCommentNewsByIdIn(List<Long> ids) {
//        ids.forEach(repository::remove);
//    }
//}
