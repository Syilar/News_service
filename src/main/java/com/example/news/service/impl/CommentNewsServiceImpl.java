//package com.example.news.service.impl;
//
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.model.CommentNews;
//import com.example.news.repository.CommentNewsRepository;
//import com.example.news.service.CommentNewsService;
//import com.example.news.web.model.CommentNewsFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.text.MessageFormat;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CommentNewsServiceImpl implements CommentNewsService {
//
//    private final CommentNewsRepository commentNewsRepository;
//
//    @Override
//    public List<CommentNews> filterBy(CommentNewsFilter filter) {
//        return null;
//    }
//
//    @Override
//    public List<CommentNews> findAll() {
//        return commentNewsRepository.findAll();
//    }
//
//    @Override
//    public CommentNews findById(Long commentNewsId) {
//        return commentNewsRepository.findById(commentNewsId).orElseThrow(() -> new EntityNotFoundException(
//                MessageFormat.format("Комментарий с таким ID {0} не найден!", commentNewsId)));
//    }
//
////    @Override
////    public List<CommentNews> findByNewsId(Long newsId) {
////        return commentNewsRepository.findByNewsId(newsId);
////    }
//
//    @Override
//    public CommentNews createCommentNews(CommentNews commentNews) {
//        return commentNewsRepository.createCommentNews(commentNews);
//    }
//
//    @Override
//    public CommentNews updateCommentNews(CommentNews commentNews) {
//        return commentNewsRepository.updateCommentNews(commentNews);
//    }
//
//    @Override
//    public void deleteCommentNewsById(Long commentNewsId) {
//        commentNewsRepository.deleteCommentNewsById(commentNewsId);
//    }
//
//    @Override
//    public void deleteCommentNewsByIdIn(List<Long> ids) {
//        commentNewsRepository.deleteCommentNewsByIdIn(ids);
//    }
//}
