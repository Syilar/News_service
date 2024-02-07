//package com.example.news.mapper.v1;
//
//import com.example.news.model.CommentNews;
//import com.example.news.service.NewsService;
//import com.example.news.web.model.CommentNewsListResponse;
//import com.example.news.web.model.CommentNewsResponse;
//import com.example.news.web.model.UpsertCommentNewsRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class CommentNewsMapper {
//
//    private final NewsService newsService;
//
//    public CommentNews requestToCommentNews(UpsertCommentNewsRequest request) {
//        CommentNews commentNews = new CommentNews();
//
//        commentNews.setComment(request.getComment());
//        commentNews.setNews(newsService.findById(request.getNewsId()));
//
//        return commentNews;
//    }
//
//    public CommentNews requestToCommentNews(Long commentId, UpsertCommentNewsRequest request) {
//        CommentNews commentNews = requestToCommentNews(request);
//
//        commentNews.setId(commentId);
//
//        return commentNews;
//    }
//
//    public CommentNewsResponse commentNewsToResponse(CommentNews commentNews) {
//        CommentNewsResponse response = new CommentNewsResponse();
//
//        response.setId(commentNews.getId());
//        response.setComment(commentNews.getComment());
//
//        return response;
//    }
//
//    public List<CommentNewsResponse> commentNewsListToCommentNewsResponseList(List<CommentNews> comments) {
//        return comments.stream().map(this::commentNewsToResponse).collect(Collectors.toList());
//    }
//
//    public CommentNewsListResponse commentNewsListToCommentNewsListResponse(List<CommentNews> comments) {
//        CommentNewsListResponse listResponse = new CommentNewsListResponse();
//
//        listResponse.setComments(commentNewsListToCommentNewsResponseList(comments));
//
//        return listResponse;
//    }
//}
