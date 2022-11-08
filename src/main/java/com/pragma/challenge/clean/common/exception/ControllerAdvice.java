package com.pragma.challenge.clean.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex){
        ErrorDto error = ErrorDto.builder().code("P-500").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDto> requestHandlerException(RequestException ex){
        ErrorDto error = ErrorDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
