package org.meli.ejercicio6_p2_d1_joyeria_las_perlas.dto;

import lombok.Data;

@Data
public class JoyaDTO {
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
