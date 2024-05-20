package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaRequestDto;
import com.example.joyeria.dto.response.JoyaResponseDto;
import com.example.joyeria.dto.response.ResponseDto;

import java.util.List;

public interface IJoyaService {
    int agregarJoya(JoyaRequestDto joyaRequestDto);
    List<JoyaResponseDto> obtenerJoyas();
    void eliminarJoya(int id);
    JoyaResponseDto editarJoya(int id, JoyaRequestDto joyaRequestDto);
}
