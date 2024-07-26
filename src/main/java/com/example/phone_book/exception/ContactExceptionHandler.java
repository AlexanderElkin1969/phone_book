package com.example.phone_book.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ContactExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ContactExceptionHandler.class);

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<?> handlerNotFoundItem(NoSuchElementException e){
        logger.error("Element by this Id is absent.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Element by this Id is absent. " + e.getMessage());
    }
}
