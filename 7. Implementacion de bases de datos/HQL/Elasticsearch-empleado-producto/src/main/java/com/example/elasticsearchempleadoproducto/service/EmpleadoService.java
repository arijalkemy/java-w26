package com.example.elasticsearchempleadoproducto.service;

import com.example.elasticsearchempleadoproducto.dto.EmpleadoDto;
import com.example.elasticsearchempleadoproducto.model.Empleado;
import com.example.elasticsearchempleadoproducto.repository.IEmpleadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoService implements IEmpleadoService {
    private final IEmpleadoRepository empleadoRepository;

    public EmpleadoService(IEmpleadoRepository empleadoRepository, ObjectMapper objectMapper) {
        this.empleadoRepository = empleadoRepository;
        this.objectMapper = objectMapper;
    }

    private final ObjectMapper objectMapper;


    @Override
    public List<Empleado> getAllEmpleados() {
        Iterable<Empleado> employIterable = empleadoRepository.findAll();
        List<Empleado> empleados = StreamSupport.stream(employIterable.spliterator(), false).toList();

        return empleados;
    }

    @Override
    public Long crearEmpleado(EmpleadoDto empleadoDto) {
        Empleado empleadoAGuardar = objectMapper.convertValue(empleadoDto, Empleado.class);
        Empleado empleadoGuardado = empleadoRepository.save(empleadoAGuardar);
        return empleadoGuardado.getId();
    }

    @Override
    public Boolean updateEmployee(Long id, EmpleadoDto empleadoDto) {
        Optional<Empleado> optional = empleadoRepository.findById(id);

        if (optional.isEmpty()) {
            return false;
        }

        Empleado empleadoGuardado = optional.get();
        Empleado empleadoActualizar = objectMapper.convertValue(empleadoDto, Empleado.class);

        empleadoActualizar.setId(empleadoGuardado.getId());
        empleadoRepository.save(empleadoActualizar);
        return true;
    }

}
