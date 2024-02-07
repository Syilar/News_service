package com.example.news.web.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertCommentNewsRequest {

    private String comment;

    @Positive(message = "ID новости должно быть больше 0!")
    @NotNull(message = "ID новости должно быть указано!")
    private Long newsId;

    @Positive(message = "ID пользователя должно быть больше 0!")
    @NotNull(message = "ID пользователя должно быть указано!")
    private Long userId;
}
