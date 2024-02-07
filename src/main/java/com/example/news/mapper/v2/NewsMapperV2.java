package com.example.news.mapper.v2;

import com.example.news.model.News;
import com.example.news.web.model.NewsListResponse;
import com.example.news.web.model.NewsResponse;
import com.example.news.web.model.NewsResponseCountComments;
import com.example.news.web.model.UpsertNewsRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@DecoratedWith(NewsMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {
        CommentNewsMapperV2.class, CategoryNewsMapperV2.class})
public interface NewsMapperV2 {

    News requestToNews(UpsertNewsRequest request);

    @Mapping(source = "newsId", target = "id")
    News requestToNews(Long newsId, UpsertNewsRequest request);

    @Mapping(target = "categoryNewsId", source = "news.categoryNews.id")
    NewsResponse newsToResponse(News news);

    List<NewsResponseCountComments> newsListToResponseListCountComments(List<News> news);

    List<NewsResponse> newsListToResponseList(List<News> news);

    NewsResponseCountComments newsToResponseCountComments(News news);

    default NewsListResponse newsListToNewsListResponse(List<News> newsList){
        NewsListResponse response = new NewsListResponse();
        response.setNews(newsList.stream()
        .map(this::newsToResponseCountComments).toList());
        return response;
    }
}
