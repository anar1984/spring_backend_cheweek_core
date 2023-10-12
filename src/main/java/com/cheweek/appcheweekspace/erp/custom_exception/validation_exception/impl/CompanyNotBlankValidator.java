package com.cheweek.appcheweekspace.erp.custom_exception.validation_exception.impl;

import com.cheweek.appcheweekspace.erp.custom_exception.validation_exception.CompanyNotBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CompanyNotBlankValidator extends RuntimeException   implements ConstraintValidator<CompanyNotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.trim().isEmpty()){
            return false;
        }
        return true;
    }
    @Override
    public void initialize(CompanyNotBlank constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
