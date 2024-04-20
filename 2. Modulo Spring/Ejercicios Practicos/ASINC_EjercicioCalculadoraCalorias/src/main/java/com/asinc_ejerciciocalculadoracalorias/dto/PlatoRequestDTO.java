package com.asinc_ejerciciocalculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoRequestDTO {
    private String nombre;
    private double peso;
}
