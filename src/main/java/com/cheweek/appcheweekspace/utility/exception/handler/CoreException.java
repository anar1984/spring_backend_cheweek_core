package com.cheweek.appcheweekspace.utility.exception.handler;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
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
    Map<String,String> params = new HashMap<>();

    public void setParam(String key ,String value){
        this.params.put(key,value);
    }

}
