package com.viajescuidados.dtos.responses;

import com.viajescuidados.dtos.UbicacionDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
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
