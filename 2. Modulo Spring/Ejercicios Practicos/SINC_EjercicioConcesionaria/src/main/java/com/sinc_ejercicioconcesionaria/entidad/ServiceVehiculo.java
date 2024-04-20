package com.sinc_ejercicioconcesionaria.entidad;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
public class ServiceVehiculo {
    private LocalDate fecha;
    private int kilometros;
    private String descripcion;
}
