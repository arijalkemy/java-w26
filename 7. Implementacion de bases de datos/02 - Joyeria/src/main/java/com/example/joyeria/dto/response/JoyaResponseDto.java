package com.example.joyeria.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaResponseDto {
    private int id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean poseePiedra;
}
