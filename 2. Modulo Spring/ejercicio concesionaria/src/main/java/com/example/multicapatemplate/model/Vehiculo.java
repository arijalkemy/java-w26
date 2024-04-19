package com.example.multicapatemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private LocalDate fecha;
    private int kilometros;
    private int puertas;
    private double precio;
    private int cantidadDuenios;
    private List<Servicio> servicios;
}
