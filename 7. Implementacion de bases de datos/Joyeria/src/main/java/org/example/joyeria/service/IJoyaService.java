package org.example.joyeria.service;

import org.example.joyeria.dto.JoyaDTO;
import org.example.joyeria.dto.JoyaResponseDTO;

import java.util.List;

public interface IJoyaService {
    JoyaResponseDTO create(JoyaDTO joya);
    List<JoyaDTO> getAllJoyas();
    JoyaDTO update(JoyaDTO joya, Long id);
    JoyaResponseDTO delete(Long id);
}
