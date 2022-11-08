package com.pragma.challenge.clean.common.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RequestException extends RuntimeException{

    private String code;

    private HttpStatus status;

    public RequestException(String code, String message, HttpStatus status){
        super(message);
        this.code = code;
        this.status = status;
    }

}
