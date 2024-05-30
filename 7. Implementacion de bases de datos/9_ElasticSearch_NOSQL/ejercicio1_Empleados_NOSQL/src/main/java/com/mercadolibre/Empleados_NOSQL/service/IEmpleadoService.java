package com.mercadolibre.Empleados_NOSQL.service;

import com.mercadolibre.Empleados_NOSQL.dto.EmpleadoRequestDto;
import com.mercadolibre.Empleados_NOSQL.dto.EmpleadoResponseDto;
import com.mercadolibre.Empleados_NOSQL.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public EmpleadoResponseDto saveEmpleado(EmpleadoRequestDto empleado);
    public EmpleadoResponseDto updateEmpleado(String id, EmpleadoRequestDto empleado);
    public List<EmpleadoResponseDto> getAllEmpleados();
}
