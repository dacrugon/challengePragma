package com.pragma.challenge.clean.infrastructure.exceptionhandler;

import com.pragma.challenge.clean.infrastructure.exception.PersonAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "Message";

    @ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handlePersonAlreadyExistsException(PersonAlreadyExistsException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.PERSON_ALREADY_EXISTS.getMessage()));
    }
}
