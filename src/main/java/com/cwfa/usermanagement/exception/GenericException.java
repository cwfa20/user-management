package com.cwfa.usermanagement.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
public class GenericException extends RuntimeException {

    private HttpStatus httpStatus;
    private String errorMessage;
}
