package com.example.ejerciciocrudconjpa.dto.request;

import lombok.Data;

@Data
public class UpdateJewelRequestDto {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
}
