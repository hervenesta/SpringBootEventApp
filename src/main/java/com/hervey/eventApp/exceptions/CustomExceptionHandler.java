package com.hervey.eventApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUsernameAlreadyExist(UsernameAlreadyExistsException ex, WebRequest webRequest){
        UsernameAlreadyExistsResponse existsResponse = new UsernameAlreadyExistsResponse(ex.getMessage());
        return new ResponseEntity(existsResponse, HttpStatus.BAD_REQUEST);
    }
}
