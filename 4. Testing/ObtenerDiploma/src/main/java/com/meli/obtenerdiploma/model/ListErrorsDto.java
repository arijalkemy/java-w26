package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
@Data
@AllArgsConstructor
public class ListErrorsDto {
    private Map<String, String> errors;
}
