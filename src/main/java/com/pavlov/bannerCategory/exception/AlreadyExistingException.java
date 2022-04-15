package com.pavlov.bannerCategory.exception;

public class AlreadyExistingException extends RuntimeException{
    public AlreadyExistingException(String field, String value) {
        super("Entity with " + field + " '" + value + "' already exists.");
    }
}
