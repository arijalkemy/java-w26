package com.example.ejercicio_implementacion_nosql_empleados.service;

import com.example.ejercicio_implementacion_nosql_empleados.model.dto.request.CreateEmpleadoRequestDto;
import com.example.ejercicio_implementacion_nosql_empleados.model.dto.request.UpdateEmpleadoRequestDto;
import com.example.ejercicio_implementacion_nosql_empleados.model.dto.response.EmpleadoResponseDto;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoResponseDto> searchAllEmpleados();
    EmpleadoResponseDto createEmpleado(CreateEmpleadoRequestDto createEmpleadoRequestDto);
    EmpleadoResponseDto updateEmpleado(Long id, UpdateEmpleadoRequestDto updateEmpleadoRequestDto);
}
