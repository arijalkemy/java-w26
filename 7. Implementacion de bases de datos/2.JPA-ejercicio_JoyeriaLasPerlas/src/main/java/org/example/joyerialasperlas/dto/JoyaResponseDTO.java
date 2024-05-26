package org.example.joyerialasperlas.dto;

import lombok.Data;

@Data
public class JoyaResponseDTO {
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
