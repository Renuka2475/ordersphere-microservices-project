package com.order.orderBook.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> httpNotFound(ResourceNotFoundException ex) {
        String message = "Order does not exist";


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse1> handleJsonParseError(HttpMessageNotReadableException ex, HttpServletRequest request) {
        String message = "Invalid request body";
        if (ex.getMessage().contains("Leading zeroes not allowed")) {
            message = "Numeric values should not have leading zeros (e.g., use 1 instead of 01)";
        }
        ErrorResponse1 error = new ErrorResponse1(
                    400,
                    "Bad Request",
                    message,
                    request.getRequestURI()
            );



        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
