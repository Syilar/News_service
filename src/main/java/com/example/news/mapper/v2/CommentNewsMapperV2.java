package com.example.news.mapper.v2;

import com.example.news.model.CommentNews;
import com.example.news.web.model.CommentNewsListResponse;
import com.example.news.web.model.CommentNewsResponse;
import com.example.news.web.model.UpsertCommentNewsRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@DecoratedWith(CommentNewsMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {NewsMapperV2.class,
        UserMapperV2.class})
public interface CommentNewsMapperV2 {

    CommentNews requestToCommentNews(UpsertCommentNewsRequest request);

    @Mapping(source = "commentNewsId", target = "id")
    CommentNews requestToCommentNews(Long commentNewsId, UpsertCommentNewsRequest request);

    @Mapping(target = "userId", source = "comment.user.id")
    @Mapping(target = "newsId", source = "comment.news.id")
    CommentNewsResponse commentNewsToResponse(CommentNews comment);

    List<CommentNewsResponse> commentNewsListToResponseList(List<CommentNews> comments);

    default CommentNewsListResponse commentNewsListToCommentNewsListResponse(List<CommentNews> comments) {
        CommentNewsListResponse response = new CommentNewsListResponse();
        response.setComments(commentNewsListToResponseList(comments));

        return response;
    }

}
