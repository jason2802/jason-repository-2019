package com.example.aop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZonedDateTime;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 9153386366344360716L;

    private final String message;
    //private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;


    public ApiException(String message,
                       // Throwable throwable,
                        HttpStatus httpStatus,
                        ZonedDateTime timestamp) {
        //super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.message = message;
        //this.throwable=throwable;
        this.httpStatus=httpStatus;
        this.timestamp=timestamp;

    }

    @Override
    public String getMessage() {
        return message;
    }

    /*
    public Throwable getThrowable() {
        return throwable;
    }
    */

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
