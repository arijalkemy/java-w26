package com.viajescuidados.dtos.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viajescuidados.dtos.UbicacionDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@Builder
public class ViajeResponseDTO {
    private Integer id;
    private Integer personaId;
    private List<Integer> cuidadores;
    private UbicacionDTO origen;
    private UbicacionDTO destino;
    private String estado;
    private Long duracionEstimadaEnMins;
    private LocalDateTime fechaComienzo;
    private LocalDateTime fechaFinalizacion;
}
