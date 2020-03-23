package com.project1.web1.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MyIllegalArgumentException.class)
    public ResponseEntity<Object> handleMyIllegalArgumentException(MyIllegalArgumentException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmptyStringException.class)
    public ResponseEntity<Object> handleMyNullPointerException(EmptyStringException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
