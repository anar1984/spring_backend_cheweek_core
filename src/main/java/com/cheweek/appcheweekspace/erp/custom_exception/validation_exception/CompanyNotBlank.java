package com.cheweek.appcheweekspace.erp.custom_exception.validation_exception;

import com.cheweek.appcheweekspace.erp.custom_exception.validation_exception.impl.CompanyNotBlankValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CompanyNotBlankValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CompanyNotBlank {
    final static String statusCode = "chw-20007";
    String message() default statusCode;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
