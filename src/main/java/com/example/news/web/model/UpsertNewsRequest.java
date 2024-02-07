package com.example.news.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertNewsRequest {

    @NotNull(message = "ID пользователя должно быть указано!")
    @Positive(message = "ID пользователья должно быть больше 0!")
    private Long userId;

    @Positive(message = "ID категории должно быть больше 0!")
    private Long categoryId;

    @NotBlank(message = "Заголовок новости должен быть заполнен!")
    @Size(min = 2, max = 30, message = "Заголовок не должен быть меньше {min} и больше {max}!")
    private String title;

    @NotBlank(message = "Содержимое новости должно быть заполнено!")
    private String content;
}
