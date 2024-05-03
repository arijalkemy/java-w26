package com.viajescuidados.mappers;

import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.viajes.EstadoViaje;
import com.viajescuidados.entities.viajes.Viaje;

import java.util.ArrayList;

public class ViajeMapper {
    public static ViajeResponseDTO crearViajeResponseDTO(Viaje viaje) {
        return ViajeResponseDTO.builder()
                .id(viaje.getId())
                .personaId(viaje.getPersona().getId())
                .cuidadores(viaje.getCuidadores().stream().map(Persona::getId).toList())
                .origen(UbicacionMapper.crearUbicacionDTO(viaje.getOrigen()))
                .destino(UbicacionMapper.crearUbicacionDTO(viaje.getDestino()))
                .estado(viaje.getEstado().name())
                .duracionEstimadaEnMins(viaje.getDuracionEstimadaEnMins())
                .fechaComienzo(viaje.getFechaComienzo())
                .fechaFinalizacion(viaje.getFechaFinalizacion())
                .build();
    }

    public static Viaje crearViaje(ViajeDTO viajeDTO) {
        return Viaje.builder()
                .origen(UbicacionMapper.crearUbicacion(viajeDTO.getOrigen()))
                .destino(UbicacionMapper.crearUbicacion(viajeDTO.getOrigen()))
                .estado(EstadoViaje.NO_INICIADO)
                .cuidadores(new ArrayList<>())
                .build();
    }
}
