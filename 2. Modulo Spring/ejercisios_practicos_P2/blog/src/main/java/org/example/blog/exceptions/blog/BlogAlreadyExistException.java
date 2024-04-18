package org.example.blog.exceptions.blog;

public class BlogAlreadyExistException extends RuntimeException {
    public BlogAlreadyExistException(String message) {
        super(message);
    }
}
