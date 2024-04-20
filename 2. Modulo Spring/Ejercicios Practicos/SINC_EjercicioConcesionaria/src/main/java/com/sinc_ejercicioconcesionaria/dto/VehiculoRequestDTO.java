package com.sinc_ejercicioconcesionaria.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class VehiculoRequestDTO {
    private String marca;
    private String modelo;
    private LocalDate fechaFabricacion;
    private int numeroKilometros;
    private int puertas;
    private int precio;
    private String moneda;
    private List<ServiceVehiculoDTO> servicesDto;
    private int cantidadDueños;
}
