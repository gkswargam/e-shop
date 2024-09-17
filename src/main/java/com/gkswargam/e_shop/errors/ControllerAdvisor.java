package com.gkswargam.e_shop.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({NoSuchElementException.class, SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<ErrorMessage> handleExceptions(Exception ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}