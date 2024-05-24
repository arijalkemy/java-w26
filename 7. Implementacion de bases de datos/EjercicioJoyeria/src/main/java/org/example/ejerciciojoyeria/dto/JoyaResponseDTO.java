package org.example.ejerciciojoyeria.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoyaResponseDTO {

    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidades;
    private boolean poseePiedra;
    private boolean venta;
}
