package com.joyerialasperlas.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ExceptionDetailDTO  {
    String message;
    Integer status;

    public ExceptionDetailDTO(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
