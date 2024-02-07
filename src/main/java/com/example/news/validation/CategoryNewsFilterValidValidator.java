package com.example.news.validation;

import com.example.news.web.model.CategoryNewsFilter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;

public class CategoryNewsFilterValidValidator implements ConstraintValidator<CategoryNewsFilterValid,
        CategoryNewsFilter> {
    @Override
    public boolean isValid(CategoryNewsFilter filter, ConstraintValidatorContext constraintValidatorContext) {
        if (ObjectUtils.anyNull(filter.getPageNumber(), filter.getPageSize())) {
            return false;
        }
        return true;
    }
}
