package com.order.placeNewOrder.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger("GlobalExceptionHandler.class");


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException ex, HttpRequest req){
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                "Bad Request",
                400,
                message,
                req.getURI()
        );

        log.error("Error response :: {} status {} ",
                errorResponse,
                HttpStatus.BAD_REQUEST );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)

    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpRequest req){

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                "Internal Server Error",
                500,
                ex.getMessage(),
                req.getURI()
        );
        log.error("Error response :: {} status {} ",response, HttpStatus.BAD_REQUEST );

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
