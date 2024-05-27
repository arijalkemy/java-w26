package org.responseentity.empleados.service;

import org.responseentity.empleados.dto.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoDTO> listAllEmpleados();
    EmpleadoDTO getEmpleadoById(String id);
    EmpleadoDTO saveEmpleado(EmpleadoDTO empleadoDTO);
    EmpleadoDTO updateEmpleado(String id, EmpleadoDTO empleadoDTO);
    void deleteEmpleado(String id);
}
