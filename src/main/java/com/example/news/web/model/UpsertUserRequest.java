package com.example.news.web.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertUserRequest {

    @NotBlank(message = "Имя пользователя должно быть заполнено!")
    @Size(min = 3, max = 30, message = "Имя пользователя не может быть меньше {min} и больше {max}!")
    private String name;

    @NotBlank(message = "Поле с фамилией пользователя должно быть заполнено!")
    private String surname;

    @Email(message = "Введен некорректный адрес электронной почты!")
    private String email;
}
