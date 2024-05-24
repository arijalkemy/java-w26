package com.bootcamp.vehiculo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiniestroDTO implements Serializable {

    private Long id;

    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;

    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;

    @JsonProperty("vehiculo_id")
    private Long vehiculoId;

}
