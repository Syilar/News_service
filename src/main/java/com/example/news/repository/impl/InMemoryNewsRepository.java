//package com.example.news.repository.impl;
//
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.model.CategoryNews;
//import com.example.news.model.CommentNews;
//import com.example.news.model.News;
//import com.example.news.model.User;
//import com.example.news.repository.CategoryNewsRepository;
//import com.example.news.repository.CommentNewsRepository;
//import com.example.news.repository.NewsRepository;
//import com.example.news.repository.UserRepository;
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
//import java.util.stream.Collectors;
//
//@Component
//public class InMemoryNewsRepository implements NewsRepository {
//
//    private UserRepository userRepository;
//
//    private CategoryNewsRepository categoryNewsRepository;
//
//    private CommentNewsRepository commentNewsRepository;
//
//    private final Map<Long, News> repository = new ConcurrentHashMap<>();
//
//    private final AtomicLong currentId = new AtomicLong(1);
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Autowired
//    public void setCategoryNewsRepository(CategoryNewsRepository categoryNewsRepository) {
//        this.categoryNewsRepository = categoryNewsRepository;
//    }
//
//    @Autowired
//    public void setCommentNewsRepository(CommentNewsRepository commentNewsRepository) {
//        this.commentNewsRepository = commentNewsRepository;
//    }
//
//    @Override
//    public List<News> findAll() {
//        return new ArrayList<>(repository.values());
//    }
//
//    @Override
//    public Optional<News> findById(Long newsId) {
//        return Optional.ofNullable(repository.get(newsId));
//    }
//
//    @Override
//    public News createNews(News news) {
//        Long newsId = currentId.getAndIncrement();
//        Long userId = news.getUser().getId();
//        Long categoryNewsId = news.getCategoryNews().getId();
//
//        User user = userRepository.findById(userId).
//                orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
//
//        CategoryNews categoryNews = categoryNewsRepository.findById(categoryNewsId)
//                .orElseThrow(() -> new EntityNotFoundException("Категория не найдена"));
//
//        news.setUser(user);
//        news.setId(newsId);
//        news.setCategoryNews(categoryNews);
//        Instant now = Instant.now();
//        news.setCreateAt(now);
//        news.setUpdateAt(now);
//
//        repository.put(newsId, news);
//        user.addNews(news);
//        categoryNews.addNews(news);
//        userRepository.updateUser(user);
//        categoryNewsRepository.updateCategoryNews(categoryNews);
//
//        return news;
//    }
//
//    @Override
//    public News updateNews(News news) {
//        Long newsId = news.getId();
//        Instant now = Instant.now();
//        News currentNews = repository.get(newsId);
//
//        if (currentNews == null) {
//            throw new EntityNotFoundException(MessageFormat.format("Новость c ID {0} не найдена!", newsId));
//        }
//
//        BeanUtils.copyNonNullProperties(news, currentNews);
//
//        currentNews.setId(newsId);
//        currentNews.setUpdateAt(now);
//        currentNews.getCategoryNews().addNews(currentNews);
//        repository.put(newsId, currentNews);
//        return currentNews;
//    }
//
//    @Override
//    public void deleteById(Long newsId) {
//        News news = repository.get(newsId);
//
//        if (news == null) {
//            throw new EntityNotFoundException(MessageFormat.format("Новость c ID {0} не найдена!", newsId));
//        }
//
//        commentNewsRepository.deleteCommentNewsByIdIn(news.getCommentNewsList().stream().map(CommentNews::getId).collect(Collectors.toList()));
//        news.getCategoryNews().remove(newsId);
//        news.getUser().removeNews(newsId);
//        repository.remove(newsId);
//    }
//
//    @Override
//    public void deleteByIdIn(List<Long> ids) {
//        for (Long i : ids) {
//            deleteById(i);
//        }
////        ids.forEach(repository::remove);
//    }
//
//    public void updateNewsCategoryNull(List<News> listNews) {
//        for (News news : listNews) {
//            news.getCategoryNews().setId(null);
//        }
//    }
//}
