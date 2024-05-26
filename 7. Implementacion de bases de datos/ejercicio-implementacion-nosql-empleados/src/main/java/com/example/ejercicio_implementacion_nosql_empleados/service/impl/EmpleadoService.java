package com.example.ejercicio_implementacion_nosql_empleados.service.impl;

import com.example.ejercicio_implementacion_nosql_empleados.model.domain.Empleado;
import com.example.ejercicio_implementacion_nosql_empleados.model.dto.request.CreateEmpleadoRequestDto;
import com.example.ejercicio_implementacion_nosql_empleados.model.dto.request.UpdateEmpleadoRequestDto;
import com.example.ejercicio_implementacion_nosql_empleados.model.dto.response.EmpleadoResponseDto;
import com.example.ejercicio_implementacion_nosql_empleados.repository.IEmpleadoRepository;
import com.example.ejercicio_implementacion_nosql_empleados.service.IEmpleadoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmpleadoService implements IEmpleadoService {
    private final IEmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoResponseDto> searchAllEmpleados() {
        ModelMapper mapper = new ModelMapper();
        Iterable<Empleado> empleados = empleadoRepository.findAll();

        List<Empleado> list = new ArrayList<>();
        empleados.forEach(list::add);

        return list.stream().map(empleado -> mapper.map(empleado, EmpleadoResponseDto.class)).toList();
    }

    @Override
    public EmpleadoResponseDto createEmpleado(CreateEmpleadoRequestDto createEmpleadoRequestDto) {
        ModelMapper mapper = new ModelMapper();
        Empleado empleado = mapper.map(createEmpleadoRequestDto, Empleado.class);

        empleadoRepository.save(empleado);

        return mapper.map(empleado, EmpleadoResponseDto.class);
    }

    @Override
    public EmpleadoResponseDto updateEmpleado(Long id, UpdateEmpleadoRequestDto updateEmpleadoRequestDto) {
        Empleado empleado = empleadoRepository.findById(id)
            .orElseThrow();

        empleado.setNombre(updateEmpleadoRequestDto.getNombre());
        empleado.setApellido(updateEmpleadoRequestDto.getApellido());
        empleado.setEdad(updateEmpleadoRequestDto.getEdad());
        empleado.setCiudad(updateEmpleadoRequestDto.getCiudad());
        empleado.setLocalidad(updateEmpleadoRequestDto.getLocalidad());
        empleadoRepository.save(empleado);

        return new ModelMapper().map(empleado, EmpleadoResponseDto.class);
    }
}
