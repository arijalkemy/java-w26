package com.example.joyeria.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
public class JoyaRequestDto {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean enVenta;
}
