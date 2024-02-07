package com.example.news.web.model;

import com.example.news.validation.UserFilterValid;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@UserFilterValid
public class UserFilter {

    private Integer pageSize;

    private Integer pageNumber;
}
