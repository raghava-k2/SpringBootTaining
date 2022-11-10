package com.webmattic.jpa.controller;

import com.webmattic.jpa.exception.UserServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity handleUserServiceException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
