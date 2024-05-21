package org.example.es_hib_empleados.service.interfaces;

import org.example.es_hib_empleados.dtos.EmpleadoDto;
import org.example.es_hib_empleados.dtos.EmpleadoResDto;
import org.example.es_hib_empleados.dtos.MessageDto;
import org.example.es_hib_empleados.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    List<Empleado> getAllEmpleados();
    EmpleadoResDto findById(String id);
    EmpleadoResDto create(EmpleadoDto newEmpleado);
    EmpleadoResDto update(String id, EmpleadoDto updatedData);
    MessageDto delete(String id);
}
