package com.cheweek.appcheweekspace.erp.custom_exception;

import com.cheweek.appcheweekspace.utility.exception.handler.CoreException;

import java.util.Map;

public class IdNotFoundException extends CoreException {
    final static String statusCode = "chw-20021";

    public IdNotFoundException() {
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
        return IdNotFoundException.statusCode;
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
        super.setMessageCode(IdNotFoundException.statusCode);
    }

    @Override
    public void setParams(Map<String, String> params) {
        super.setParams(params);
    }
}


