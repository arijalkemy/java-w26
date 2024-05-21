package com.example.elastic.service;


import com.example.elastic.model.Empleado;
import com.example.elastic.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public int save(Empleado empleado) {
        return empleadoRepository.save(empleado).getId();
    }

    @Override
    public Empleado editEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
        return empleado;
    }
}
