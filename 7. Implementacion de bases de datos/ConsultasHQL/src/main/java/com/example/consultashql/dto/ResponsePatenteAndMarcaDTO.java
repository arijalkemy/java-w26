package com.example.consultashql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePatenteAndMarcaDTO {
    private String marca;
    private String patente;
}
