package com.sinc_ejercicioconcesionaria.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Vehiculo {
    private String marca;
    private String modelo;
    private LocalDate fechaFabricacion;
    private int numeroKilometros;
    private int puertas;
    private int precio;
    private String moneda;
    private List<ServiceVehiculo> services;
    private int cantidadDueños;
}
