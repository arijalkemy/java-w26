package com.spring.calculadoracalorias.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoRequestDTO {
    private String nombre;
    private double peso;
}
