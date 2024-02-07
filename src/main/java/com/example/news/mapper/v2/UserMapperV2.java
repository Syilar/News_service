package com.example.news.mapper.v2;

import com.example.news.model.User;
import com.example.news.web.model.UpsertUserRequest;
import com.example.news.web.model.UserListResponse;
import com.example.news.web.model.UserResponse;
import com.example.news.web.model.UserResponseCountComments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {NewsMapperV2.class,
        CommentNewsMapperV2.class})
public interface UserMapperV2 {

    User requestToUser(UpsertUserRequest request);

    @Mapping(source = "userId", target = "id")
    User requestToUser(Long userId, UpsertUserRequest request);

    UserResponse userToResponse(User user);

    UserResponseCountComments userToResponseCountComment(User user);

   default UserListResponse userListToUserListResponse(List<User> users) {
       UserListResponse userListResponse = new UserListResponse();

       userListResponse.setUsers(users.stream()
       .map(this::userToResponseCountComment)
       .collect(Collectors.toList()));

       return userListResponse;
   }
}
