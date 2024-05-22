package com.example.joyeriaLasPerlas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JewerlyRequestDTO {
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
