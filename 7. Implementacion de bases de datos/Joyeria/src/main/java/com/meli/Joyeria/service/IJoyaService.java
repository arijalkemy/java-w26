package com.meli.Joyeria.service;

import com.meli.Joyeria.dto.CreateResponseDto;
import com.meli.Joyeria.dto.JoyaDto;

import java.util.List;

public interface IJoyaService {
    CreateResponseDto createJoya(JoyaDto joya);

    List<JoyaDto> getAllJoya();

    void deleteJoya(Long id);

    JoyaDto updateJoya(Long id, JoyaDto joya);
}
