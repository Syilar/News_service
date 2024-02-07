package com.example.news.service.impl;

import com.example.news.aop.CheckOwnerComment;
import com.example.news.exception.EntityNotFoundException;
import com.example.news.model.CommentNews;
import com.example.news.model.News;
import com.example.news.model.User;
import com.example.news.repository.DatabaseCommentNewsRepository;
import com.example.news.service.CommentNewsService;
import com.example.news.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseCommentNewsService implements CommentNewsService {

    private final DatabaseCommentNewsRepository commentNewsRepository;
    private final DatabaseNewsService newsService;

    private final DatabaseUserService userService;

    @Override
    public List<CommentNews> findAll() {
        return commentNewsRepository.findAll();
    }

    @Override
    public CommentNews findById(Long commentNewsId) {
        return commentNewsRepository.findById(
                commentNewsId).orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format("Комментарий с ID {} не найден", commentNewsId)));
    }

    @Override
    public List<CommentNews> findByNewsId(Long newsId) {
        News news = newsService.findById(newsId);

        return news.getListComments();
    }

    @Override
    public CommentNews createCommentNews(CommentNews commentNews) {
        User user = userService.findById(commentNews.getUser().getId());
        News news = newsService.findById(commentNews.getNews().getId());
        commentNews.setNews(news);
        commentNews.setUser(user);
        return commentNewsRepository.save(commentNews);
    }

    @Override
    @CheckOwnerComment
    public CommentNews updateCommentNews(CommentNews commentNews) {
        User user = userService.findById(commentNews.getUser().getId());
        News news = newsService.findById(commentNews.getNews().getId());
        CommentNews existedComment = findById(commentNews.getId());

        BeanUtils.copyNonNullProperties(commentNews, existedComment);
        existedComment.setNews(news);
        existedComment.setUser(user);
        return commentNewsRepository.save(existedComment);
    }

    @Override
    @CheckOwnerComment
    public void deleteCommentNewsById(Long commentNewsId) {
        commentNewsRepository.deleteById(commentNewsId);
    }

    @Override
    public void deleteCommentNewsByIdIn(List<Long> ids) {
        commentNewsRepository.deleteAllById(ids);
    }
}
