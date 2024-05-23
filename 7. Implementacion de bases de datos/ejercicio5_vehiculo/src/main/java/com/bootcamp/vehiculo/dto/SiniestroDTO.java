package com.bootcamp.vehiculo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class SiniestroDTO {

    private Long id;

    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;

    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;

    private VehiculoDTO vehiculo;

}
