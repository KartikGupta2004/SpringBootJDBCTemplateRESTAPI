package com.neueda.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //custom Exception
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    //global Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex){
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexcepted error occured! "+ex.getMessage());

    }

}