package com.example.siniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatenteMarcaModeloDto {
    private String patente;
    private String marca;
    private String modelo;
}
