package com.example.multicapatemplate.dto;

import com.example.multicapatemplate.model.Servicio;
import com.example.multicapatemplate.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class VehiculoDto {
    private String placa;
    private String marca;
    private String modelo;
    private LocalDate fecha;
    private int kilometros;
    private int puertas;
    private double precio;
    private int cantidadDuenios;

    public VehiculoDto( Vehiculo vehiculo) {
        this.placa = vehiculo.getPlaca();
        this.marca = vehiculo.getMarca();
        this.modelo = vehiculo.getModelo();
        this.fecha = vehiculo.getFecha();
        this.kilometros = vehiculo.getKilometros();
        this.puertas = vehiculo.getPuertas();
        this.precio = vehiculo.getPrecio();
        this.cantidadDuenios = vehiculo.getCantidadDuenios();
    }
}
