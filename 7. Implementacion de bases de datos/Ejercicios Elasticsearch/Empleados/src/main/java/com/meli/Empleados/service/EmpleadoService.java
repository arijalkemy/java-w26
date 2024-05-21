package com.meli.Empleados.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.Empleados.dto.EmpleadoDto;
import com.meli.Empleados.model.Empleado;
import com.meli.Empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    ObjectMapper mapper = new ObjectMapper();

    public EmpleadoDto create(EmpleadoDto empleadoDto) {
        Empleado empleado = mapper.convertValue(empleadoDto, Empleado.class);
        empleadoRepository.save(empleado);
        return empleadoDto;
    }
}
