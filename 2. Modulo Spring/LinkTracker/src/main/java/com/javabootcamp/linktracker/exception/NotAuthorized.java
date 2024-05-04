package com.javabootcamp.linktracker.exception;

public class NotAuthorized extends RuntimeException{
    public NotAuthorized(String error)
    {
        super(error);
    }
}
