package org.example.vehiculos.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.vehiculos.entity.Vehiculo;

@Getter
@Setter
public class VehiculoSiniestroDTO {
    private String patente;
    private String marca;
    private String modelo;
    private Integer perdidaSiniestro;
}
