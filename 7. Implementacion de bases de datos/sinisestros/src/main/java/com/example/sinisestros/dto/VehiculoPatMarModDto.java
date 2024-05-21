package com.example.sinisestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class VehiculoPatMarModDto {
    private String patente;
    private String marca;
    private String modelo;
}
