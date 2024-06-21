package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


@Data
@AllArgsConstructor
public class ErrorDTO {

    private String message;

    @JsonInclude(NON_NULL)
    private Object detail;
}
