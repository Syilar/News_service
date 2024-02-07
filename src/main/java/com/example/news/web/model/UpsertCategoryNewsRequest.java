package com.example.news.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertCategoryNewsRequest {

    @NotBlank(message = "Заголовок категории новости должен быть заполнен!")
    @Size(min = 2, max = 30, message = "Заголовок не должен быть меньше {min} и больше {max}!")
    private String title;

    private String description;

}
