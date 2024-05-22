package com.ejerciciosjpa.nosqlimpl.service;

import com.ejerciciosjpa.nosqlimpl.dto.EmpleadoRequestDto;
import com.ejerciciosjpa.nosqlimpl.dto.EmpleadoResponseDto;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoResponseDto> getAllEmpleados();
    EmpleadoResponseDto save(EmpleadoRequestDto request);
    EmpleadoResponseDto modify(String id, EmpleadoRequestDto request);
}
