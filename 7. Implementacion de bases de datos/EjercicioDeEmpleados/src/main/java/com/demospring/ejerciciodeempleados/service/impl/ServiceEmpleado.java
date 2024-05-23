package com.demospring.ejerciciodeempleados.service.impl;

import com.demospring.ejerciciodeempleados.model.Empleado;
import com.demospring.ejerciciodeempleados.repository.IEmpleadoRepository;
import com.demospring.ejerciciodeempleados.service.IServiceEmpleado;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceEmpleado implements IServiceEmpleado {
    private final IEmpleadoRepository iEmpleadoRepository;

    @Override
    public List<Empleado> obtenerEmpleados() {
        return iEmpleadoRepository.findAll();
    }

    @Override
    public void crearEmpleado(Empleado empleado) {
        iEmpleadoRepository.save(empleado);
    }
}
