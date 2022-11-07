package com.webmattic.example.controller;

import com.webmattic.example.exceptions.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity handleValidationException(ValidationException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
