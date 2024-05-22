package org.example.empleados.service;

import org.example.empleados.dto.EmpleadoDto;

import java.util.List;

public interface IEmpleadoService {
    public void crearEmpleado(EmpleadoDto empleadoDto);

    public void editarEmpleado(EmpleadoDto empleadoDto);

    public List<EmpleadoDto> findAllEmpleados();
}
