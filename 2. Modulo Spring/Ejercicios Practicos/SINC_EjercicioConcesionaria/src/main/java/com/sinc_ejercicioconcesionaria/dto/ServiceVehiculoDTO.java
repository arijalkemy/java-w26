package com.sinc_ejercicioconcesionaria.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ServiceVehiculoDTO {
    private LocalDate fecha;
    private int kilometros;
    private String descripcion;
}
