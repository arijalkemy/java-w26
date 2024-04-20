package org.responseentity.linktracker.exceptions;

import lombok.Data;

@Data
public class CustomIllegalArgumentExeption extends IllegalArgumentException{
    public CustomIllegalArgumentExeption(String message){
        super(message);
    }
}
