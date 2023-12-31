package com.cheweek.appcheweekspace.utility.exception.handler;

import com.cheweek.appcheweekspace.utility.SessionManager;
import com.cheweek.appcheweekspace.utility.exception.ClientServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
@RequiredArgsConstructor
@Log4j2
public class ExceptionHandler  {
    private final SessionManager sessionManager;

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
        return buildResponseEntity(ex, request);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        return getResponseEntity(ex, status, request, status.getReasonPhrase(), status.value(), status.getReasonPhrase(), "", "", null, sessionManager.getLang());
    }

    private ResponseEntity<Object> getResponseEntity(Exception ex,
                                                     HttpStatus status,
                                                     WebRequest request,
                                                     String message,
                                                     int statusCode,
                                                     String appError,
                                                     String errorType,
                                                     String messageCode,
                                                     Map<String, String> params,
                                                     String lang
    ) {
        ResponseException responseException = ResponseException.builder()
                .status(statusCode)
                .errorType(errorType)
                .messageCode(messageCode)
                .params(params)
                .lang(lang)
                .error(appError)
                .message(message)
                .errorDetail(ex.getMessage())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
        ResponseEntity<Object> responseExceptionResponseEntity = new ResponseEntity<>(responseException, status);
        return responseExceptionResponseEntity;
    }

    private ResponseEntity<Object> buildResponseEntity(Exception ex, WebRequest request) {
        String message = "Unexpected Exception";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String appError = status.getReasonPhrase();
        String errorType = "";
        String messageCode = "";
        String lang = sessionManager.getLang();
        Map<String, String> params = new HashMap<>();

        int statusCode = status.value();
        if(ex instanceof ClientServiceException){
            status = HttpStatus.BAD_REQUEST;
            message = ex.getMessage();
            statusCode = Integer.parseInt(((ClientServiceException) ex).getStatusCode());
            appError = "Application error";
            errorType = ((ClientServiceException) ex).getErrorType();
            messageCode = ((ClientServiceException) ex).getMessageCode();
            params = ((ClientServiceException) ex).getParams();
            lang = ((ClientServiceException) ex).getLang();
        }
        else if (ex instanceof CoreException) {
            status = HttpStatus.BAD_REQUEST;
            message = ex.getMessage();
            log.info("core"+ ((CoreException) ex).getMessageCode());
            statusCode = ((CoreException) ex).getStatusCode();
            appError = "Application error";
            errorType = ((CoreException) ex).getErrorType();
            messageCode = ((CoreException) ex).getMessageCode();
            params = ((CoreException) ex).getParams();
            lang = sessionManager.getLang();
        }
        else if (ex instanceof MethodArgumentNotValidException) {
            String regex = "\\bchw-\\w+\\b";
            String metin = ex.getMessage();

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(metin);
            while (matcher.find()) {
                messageCode  = matcher.group();
            }
            status = HttpStatus.BAD_REQUEST;
            message = ex.getMessage();
            log.info("messageCode : "+messageCode);
            statusCode = ((MethodArgumentNotValidException) ex).getStatusCode().value();
            appError = "Validation error";
            errorType = "Validation";
            params = null;
            lang = sessionManager.getLang();
        }

        return getResponseEntity(ex,
                status,
                request,
                message,
                statusCode,
                appError,
                errorType,
                messageCode,
                params,
                lang);
    }


}
