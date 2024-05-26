package org.example.joyerialasperlas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoyaRequestDTO {
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
