package com.example.news.web.model;

import com.example.news.validation.CategoryNewsFilterValid;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@CategoryNewsFilterValid
public class CategoryNewsFilter {

    private Integer pageSize;

    private Integer pageNumber;

}
