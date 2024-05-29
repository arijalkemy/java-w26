package com.w26.seguros_autos.seguros_autos.mediator.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostVehiculo implements Serializable {
    String patente;
    String marca;
    String modelo;
    Integer cantidadRuedas;
    LocalDate anoFabricacion;
}
