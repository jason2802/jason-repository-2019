package com.example.aop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.ws.Response;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiRequestHandler {
    private static final long serialVersionUID = 9153386366344360716L;

    @ExceptionHandler(value={ApiRequestException.class})
    public ResponseEntity<Object> handlerApiRequestException(ApiRequestException e){

        HttpStatus httpStatusBadRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
               // e,
                httpStatusBadRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException, httpStatusBadRequest);

    }

}
