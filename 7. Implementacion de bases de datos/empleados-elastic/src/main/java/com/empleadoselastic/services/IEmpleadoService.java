package com.empleadoselastic.services;

import com.empleadoselastic.DTOs.EmpleadoRequestDTO;
import com.empleadoselastic.models.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public Empleado crear(EmpleadoRequestDTO empleadoRequestDTO);
    List<Empleado> getEmpleados();
    Empleado actualizar(String id, EmpleadoRequestDTO empleadoRequestDTO);
}
