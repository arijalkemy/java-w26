package com.demospring.joyerialasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class JoyaRequestDTO {
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;
}
