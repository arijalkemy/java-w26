package org.ejercicio.empleados.service;

import java.util.List;

import org.ejercicio.empleados.dto.EmpleadoDto;

public interface IEmpleadoService {
    String crearEmpleado(EmpleadoDto empleadoDto);

    List<EmpleadoDto> obtenerEmpleados();

    EmpleadoDto obtenerEmpleadoPorId(String id);

    String actualizarEmpleado(String id, EmpleadoDto empleadoDto);
}