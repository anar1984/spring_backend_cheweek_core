package com.cheweek.spring_backend_cheweek_core.utility;

import java.io.PrintWriter;
import java.io.StringWriter;

public class QException extends  Exception{
    private String message;

    public QException(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);

        this.message = sw.toString();
    }

    public QException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
