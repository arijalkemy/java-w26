package org.ejercicio.joyerialasperlas.service;

import org.ejercicio.joyerialasperlas.dto.JoyaCreateDto;
import org.ejercicio.joyerialasperlas.dto.JoyaCreatedDto;
import org.ejercicio.joyerialasperlas.dto.JoyaResponseDto;
import org.ejercicio.joyerialasperlas.dto.JoyaUpdateDto;

import java.util.List;

public interface IJoyaService {
    JoyaCreatedDto guardarJoya(JoyaCreateDto joyaDto);
    JoyaResponseDto actualizarJoya(Long id,JoyaUpdateDto joyaDto);
    List<JoyaResponseDto> obtenerJoyas();
    void eliminarJoya(Long id);
}
