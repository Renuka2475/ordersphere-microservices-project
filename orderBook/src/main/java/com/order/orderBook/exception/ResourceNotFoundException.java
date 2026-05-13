package com.order.orderBook.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(RuntimeException ex){
        super(ex);
    }
}
