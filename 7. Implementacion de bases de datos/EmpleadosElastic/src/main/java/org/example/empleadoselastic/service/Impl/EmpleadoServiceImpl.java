package org.example.empleadoselastic.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.empleadoselastic.dto.EmpleadoDTO;
import org.example.empleadoselastic.entity.Empleado;
import org.example.empleadoselastic.repository.IEmpleadoRepository;
import org.example.empleadoselastic.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public EmpleadoServiceImpl() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public EmpleadoDTO saveEmpleado(EmpleadoDTO empleado) {
        return convertToEmpleadoDTO(empleadoRepository.save(convertToEmpleadoDTO(empleado)));

    }

    Empleado convertToEmpleadoDTO(EmpleadoDTO empleado) {
        return objectMapper.convertValue(empleado, Empleado.class);
    }

    EmpleadoDTO convertToEmpleadoDTO(Empleado empleado) {
        return objectMapper.convertValue(empleado, EmpleadoDTO.class);
    }
}
