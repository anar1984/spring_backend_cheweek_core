package com.cheweek.spring_backend_cheweek_core.exception;



import com.cheweek.spring_backend_cheweek_core.exception.handler.CoreException;

import java.util.Map;


public class TableRowLimitException extends CoreException {
    final static int statusCode = 604;



    public TableRowLimitException() {
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

