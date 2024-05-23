package com.implementacionDB.joyeria.exception.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO implements Serializable {
    private String message;
}
