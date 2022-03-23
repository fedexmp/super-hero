package com.superhero.exceptions;

import com.superhero.model.ExceptionError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    /*
        Handler de exceptions
     */


    @ExceptionHandler(value = { UserException.class})
    protected ResponseEntity<Object> handleUserException(
            UserException ex, WebRequest request) {
        ExceptionError error = new ExceptionError();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMensaje());
        error.setPath(ex.getPath());
        error.setTimestamp(new Date());
        error.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return handleExceptionInternal(ex, error,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}