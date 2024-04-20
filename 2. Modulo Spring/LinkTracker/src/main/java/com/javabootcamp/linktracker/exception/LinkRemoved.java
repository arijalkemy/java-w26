package com.javabootcamp.linktracker.exception;

public class LinkRemoved extends RuntimeException{
    public LinkRemoved(String message)
    {
        super(message);
    }
}
