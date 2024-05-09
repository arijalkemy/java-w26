package com.viajescuidados.services.interfaces;

import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;

public interface IViajesService {
    ViajeResponseDTO crearViaje(ViajeDTO viajeDTO, Integer personaId);

    ViajeResponseDTO comenzarViaje(Integer id);
}
