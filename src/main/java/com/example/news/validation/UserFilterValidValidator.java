package com.example.news.validation;

import com.example.news.web.model.UserFilter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;

public class UserFilterValidValidator implements ConstraintValidator<UserFilterValid, UserFilter> {
    @Override
    public boolean isValid(UserFilter filter, ConstraintValidatorContext constraintValidatorContext) {
        if (ObjectUtils.anyNull(filter.getPageNumber(), filter.getPageSize())) {
            return false;
        }
        return true;
    }
}
