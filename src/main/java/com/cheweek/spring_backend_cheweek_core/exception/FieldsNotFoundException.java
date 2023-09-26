package com.cheweek.spring_backend_cheweek_core.exception;




import com.cheweek.spring_backend_cheweek_core.exception.handler.CoreException;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class FieldsNotFoundException extends CoreException {
    final static int statusCode = 603;



    public FieldsNotFoundException() {
        super();
    }

    @Override
    public int getStatusCode() {
        return super.getStatusCode();
    }

    @Override
    public String getErrorType() {
        return super.getErrorType();
    }

    @Override
    public String getMessageCode() {
        return super.getMessageCode();
    }

    @Override
    public Map<String, String> getParams() {
        return super.getParams();
    }

    @Override
    public void setStatusCode(int statusCode) {
        super.setStatusCode(statusCode);
    }

    @Override
    public void setErrorType(String errorType) {
        super.setErrorType(errorType);
    }

    @Override
    public void setMessageCode(String messageCode) {
        super.setMessageCode(messageCode);
    }

    @Override
    public void setParams(Map<String, String> params) {
        super.setParams(params);
    }
}

