package com.example.elasticsearchempleadoproducto.service;

import com.example.elasticsearchempleadoproducto.dto.EmpleadoDto;
import com.example.elasticsearchempleadoproducto.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public List<Empleado> getAllEmpleados();

    public Long crearEmpleado(EmpleadoDto product);
    public Boolean updateEmployee(Long id, EmpleadoDto product);

}
