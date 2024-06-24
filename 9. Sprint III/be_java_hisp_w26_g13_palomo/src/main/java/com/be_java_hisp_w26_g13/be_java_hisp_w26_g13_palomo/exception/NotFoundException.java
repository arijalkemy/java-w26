package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
