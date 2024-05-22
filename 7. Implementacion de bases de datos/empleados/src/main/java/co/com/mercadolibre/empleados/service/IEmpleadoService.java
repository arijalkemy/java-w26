package co.com.mercadolibre.empleados.service;

import co.com.mercadolibre.empleados.dto.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoService {
    EmpleadoDTO create(EmpleadoDTO empleadoDTO);
    EmpleadoDTO update(EmpleadoDTO empleadoDTO, String id);
    List<EmpleadoDTO> findAll();
}
