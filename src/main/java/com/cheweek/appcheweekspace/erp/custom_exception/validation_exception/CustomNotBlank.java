package com.cheweek.appcheweekspace.erp.custom_exception.validation_exception;

import com.cheweek.appcheweekspace.erp.custom_exception.validation_exception.impl.CustomNotBlankValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomNotBlankValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomNotBlank {
    String message() default "is not empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
