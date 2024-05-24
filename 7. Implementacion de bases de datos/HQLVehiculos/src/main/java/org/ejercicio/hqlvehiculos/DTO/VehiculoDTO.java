package org.ejercicio.hqlvehiculos.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehiculoDTO {
    private Long idVehículo;

    private String patente;

    private String marca;

    private String modelo;

    private LocalDate fechaFabricacion;

    private Integer cantidadDeRuedas;

    private List<SiniestroDTO> siniestros;

    private Double perdida;
}
