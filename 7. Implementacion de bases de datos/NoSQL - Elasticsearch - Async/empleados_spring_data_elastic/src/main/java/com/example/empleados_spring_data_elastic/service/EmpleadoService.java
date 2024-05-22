package com.example.empleados_spring_data_elastic.service;


import com.example.empleados_spring_data_elastic.domain.Empleado;
import com.example.empleados_spring_data_elastic.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }
}
