package org.ejercicio.empleados.services;

import java.util.List;

import org.ejercicio.empleados.dtos.EmpleadoDto;

public interface IEmpleadoService {
    String crearEmpleado(EmpleadoDto empleadoDto);

    List<EmpleadoDto> obtenerEmpleados();

    EmpleadoDto obtenerEmpleadoPorId(String id);

    String actualizarEmpleado(String id, EmpleadoDto empleadoDto);
}
