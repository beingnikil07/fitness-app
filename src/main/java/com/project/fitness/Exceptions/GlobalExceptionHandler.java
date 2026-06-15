package com.project.fitness.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //for handling specific type of exception
    @ExceptionHandler(UserNameAlreadyExist.class)
    public  ResponseEntity<?> handleUserAlreadyExist(UserNameAlreadyExist ex){
        return ResponseEntity.ok(ex.getMessage());
    }

    //for global errors
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handleRuntimeException(RuntimeException ex){
        Map<String,Object> error=new HashMap<>();
        error.put("timestamp:", LocalDateTime.now());
        error.put("message",ex.getMessage());
        error.put("status", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
