package org.example.vehiculos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.vehiculos.entity.Siniestro;
import org.example.vehiculos.entity.Vehiculo;

@Getter
@Setter
@AllArgsConstructor
public class VehiculoSiniestro {
    private String patente;
    private String marca;
    private String modelo;
    private Long perdidaSiniestro;
}
