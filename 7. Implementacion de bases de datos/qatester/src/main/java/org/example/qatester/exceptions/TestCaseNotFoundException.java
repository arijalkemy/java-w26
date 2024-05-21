package org.example.qatester.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestCaseNotFoundException extends RuntimeException{
    public TestCaseNotFoundException(String message){
        super(message);
    }
}
