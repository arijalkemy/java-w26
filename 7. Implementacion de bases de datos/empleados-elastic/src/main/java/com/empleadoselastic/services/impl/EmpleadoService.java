package com.empleadoselastic.services.impl;

import com.empleadoselastic.DTOs.EmpleadoRequestDTO;
import com.empleadoselastic.exception.EmpleadoNotFound;
import com.empleadoselastic.models.Empleado;
import com.empleadoselastic.repositories.IEmpleadoRepository;
import com.empleadoselastic.services.IEmpleadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

    private final IEmpleadoRepository empleadoRepository;

    public EmpleadoService(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Empleado crear(EmpleadoRequestDTO empleadoRequestDTO) {
        ObjectMapper objectMapper = new ObjectMapper();

        return empleadoRepository.save(objectMapper.convertValue(
                empleadoRequestDTO,
                Empleado.class
        ));
    }

    @Override
    public List<Empleado> getEmpleados() {
        return this.empleadoRepository.findAll();
    }

    @Override
    public Empleado actualizar(String id, EmpleadoRequestDTO empleadoRequestDTO) {
        Empleado empleado = this.empleadoRepository
                .findById(id)
                .orElseThrow(() -> new EmpleadoNotFound("Empleado no encontrado"));
        ObjectMapper objectMapper = new ObjectMapper();
        Empleado empleadoActualizado = objectMapper.convertValue(
                empleadoRequestDTO,
                Empleado.class
        );
        empleadoActualizado.setId(id);
        return this.empleadoRepository.save(empleadoActualizado);
    }
}
