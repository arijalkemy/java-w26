package org.example.empleados.service;

import org.example.empleados.model.dto.EmpleadoRequestDTO;
import org.example.empleados.model.dto.EmpleadoResponseDTO;

import java.util.List;

public interface IEmpleadoService {
    EmpleadoResponseDTO create(EmpleadoRequestDTO empleado);
    List<EmpleadoResponseDTO> getAll();
}
