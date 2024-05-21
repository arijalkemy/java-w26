package org.example.empleados.service;

import org.example.empleados.model.Empleado;
import org.example.empleados.model.dto.EmpleadoRequestDTO;
import org.example.empleados.model.dto.EmpleadoResponseDTO;
import org.example.empleados.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    IEmpleadoRepository repository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public EmpleadoResponseDTO create(EmpleadoRequestDTO empleadoRequestDTO) {
        Empleado empleadoGuardado = repository.save(mapToEntity(empleadoRequestDTO));
        return mapToDTO(empleadoGuardado);
    }

    @Override
    public List<EmpleadoResponseDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).toList();
    }

    private EmpleadoResponseDTO mapToDTO(Empleado empleado) {
        return mapper.map(empleado, EmpleadoResponseDTO.class);
    }

    private Empleado mapToEntity(EmpleadoRequestDTO empleadoRequestDTO) {
        return mapper.map(empleadoRequestDTO, Empleado.class);
    }
}
