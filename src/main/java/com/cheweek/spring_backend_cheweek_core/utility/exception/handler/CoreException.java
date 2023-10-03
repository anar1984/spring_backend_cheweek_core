package com.cheweek.spring_backend_cheweek_core.utility.exception.handler;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PROTECTED)
public  class CoreException extends RuntimeException {

    int statusCode = 0;
    String errorType;
    String messageCode;
    String message;
    String lang;
    Map<String,String> params;


}