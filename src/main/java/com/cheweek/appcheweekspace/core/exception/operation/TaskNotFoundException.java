package com.cheweek.appcheweekspace.core.exception.operation;

import com.cheweek.appcheweekspace.utility.exception.handler.CoreException;

import java.util.Map;

public class TaskNotFoundException extends CoreException {
    final static String statusCode = "chw-core-601";
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
        return statusCode;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String getLang() {
        return super.getLang();
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
    public void setMessage(String message) {
        super.setMessage(message);
    }

    @Override
    public void setLang(String lang) {
        super.setLang(lang);
    }

    @Override
    public void setParams(Map<String, String> params) {
        super.setParams(params);
    }
}
