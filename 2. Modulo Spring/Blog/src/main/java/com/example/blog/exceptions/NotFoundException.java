package com.example.blog.exceptions;

import org.apache.catalina.startup.ClassLoaderFactory;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
