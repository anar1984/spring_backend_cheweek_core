package com.cheweek.appcheweekspace.utility.exception;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PROTECTED)
public class ClientServiceException extends RuntimeException {
    String statusCode;
    String status;
    String error;
    String errorType;
    String messageCode;
    Map<String,String> params;
    String lang;
    String message;
    String errorDetail;
    String path;
    String timestamp;
}