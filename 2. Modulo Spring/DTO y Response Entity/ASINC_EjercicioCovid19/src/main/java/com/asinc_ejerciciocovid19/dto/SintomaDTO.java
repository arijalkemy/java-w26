package com.asinc_ejerciciocovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SintomaDTO {
    private int codigo;
    private String nombre;
    private String nivelDeGravedad;
}
