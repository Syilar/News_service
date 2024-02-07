//package com.example.news.mapper.v1;
//
//import com.example.news.model.CommentNews;
//import com.example.news.model.News;
//import com.example.news.service.CategoryNewsService;
//import com.example.news.service.CommentNewsService;
//import com.example.news.service.UserService;
//import com.example.news.web.model.CommentNewsResponse;
//import com.example.news.web.model.NewsListResponse;
//import com.example.news.web.model.NewsResponse;
//import com.example.news.web.model.UpsertNewsRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class NewsMapper {
//
//    private final CommentNewsMapper commentNewsMapper;
//
//    private final UserService userService;
//
//    private final CategoryNewsService categoryNewsService;
//
//    private final CommentNewsService commentNewsService;
//
//    public News requestToNews(UpsertNewsRequest request) {
//        News news = new News();
//
//        news.setTitle(request.getTitle());
//        news.setContent(request.getContent());
//        news.setUser(userService.findById(request.getUserId()));
//        news.setCategoryNews(categoryNewsService.findById(request.getCategoryId()));
//
//        return news;
//    }
//
//    public News requestToNews(Long newsId, UpsertNewsRequest request) {
//        News news = requestToNews(request);
//        news.setId(newsId);
//
//        return news;
//    }

//    public NewsResponse newsToResponse(News news) {
//        NewsResponse newsResponse = new NewsResponse();
//
//        newsResponse.setId(news.getId());
//        newsResponse.setTitle(news.getTitle());
//        newsResponse.setContent(news.getContent());
//        newsResponse.setCategoryNewsId(news.getCategoryNews().getId());
//
//        List<CommentNews> comments = commentNewsService.findByNewsId(news.getId());
//        newsResponse.setListComments(commentNewsMapper.commentNewsListToCommentNewsResponseList(comments));
//
//        return newsResponse;
//    }

//    public List<NewsResponse> newsListToResponseList(List<News> news) {
//        return news.stream().map(this::newsToResponse).collect(Collectors.toList());
//    }

//    public NewsListResponse newsListToNewsListResponse(List<News> news) {
//        NewsListResponse response = new NewsListResponse();
//
//        response.setNews(newsListToResponseList(news));
//
//        return response;
//    }
//}
