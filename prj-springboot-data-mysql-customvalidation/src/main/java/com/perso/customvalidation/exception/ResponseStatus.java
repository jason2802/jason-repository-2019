package com.perso.customvalidation.exception;

import org.springframework.http.HttpStatus;

public @interface ResponseStatus {

    HttpStatus value();

}
