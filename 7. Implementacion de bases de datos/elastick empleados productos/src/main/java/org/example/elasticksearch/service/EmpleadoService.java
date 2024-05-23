package org.example.elasticksearch.service;

import org.example.elasticksearch.domain.Empleado;
import org.example.elasticksearch.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService implements IEmpleadoService{
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
