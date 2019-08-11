package com.example.aop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApiRequestException extends RuntimeException {
    private static final long serialVersionUID = 9153386366344360716L;
	private String resourceName;

    public ApiRequestException(String message) {
        //super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        //super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        super(message, cause);
    }

    public String getResourceName() {
        return resourceName;
    }

}
