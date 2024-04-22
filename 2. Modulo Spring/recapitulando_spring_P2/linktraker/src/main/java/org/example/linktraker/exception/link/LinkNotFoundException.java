package org.example.linktraker.exception.link;

import lombok.NoArgsConstructor;

public class LinkNotFoundException extends RuntimeException{
    public LinkNotFoundException(String message){
        super(message);
    }
}
