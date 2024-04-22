package com.autos.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    private Integer id;
    private String marca;
    private String modelo;
    private LocalDate fechaManufactura;
    private Integer kilometros;
    private Integer puertas;
    private Integer precio;
    private String divisa;
    private List<ServiceAuto> serviceHechos;
    private Integer cantidadPropietarios;
}
