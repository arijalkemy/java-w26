package com.viajescuidados.mappers;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.entities.ubicaciones.Ubicacion;

public class UbicacionMapper {
    public static Ubicacion crearUbicacion(UbicacionDTO ubiDTO) {
        return new Ubicacion(ubiDTO.getDireccion(), ubiDTO.getLatitud(), ubiDTO.getLongitud());
    }

    public static UbicacionDTO crearUbicacionDTO(Ubicacion ubicacion) {
        return new UbicacionDTO(ubicacion.getDireccion(), ubicacion.getLatitud(), ubicacion.getLongitud());
    }
}
