package com.cheweek.appcheweekspace.erp.custom_exception.validation_exception.impl;

import com.cheweek.appcheweekspace.erp.custom_exception.validation_exception.CustomNotBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomNotBlankValidator  implements ConstraintValidator<CustomNotBlank, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.trim().isEmpty()){
            return false;
        }
        return true;
    }
}
