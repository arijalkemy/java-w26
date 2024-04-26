package org.example.be_java_hisp_w26_g04.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadRequestException extends RuntimeException{
    BadRequestException(String message){
        super(message);
    }
}
