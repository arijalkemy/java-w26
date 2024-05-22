package org.example.empleados.service;


import org.example.empleados.dto.EmpleadoDto;
import org.example.empleados.exception.NotFoundException;
import org.example.empleados.model.Empleado;
import org.example.empleados.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    IEmpleadoRepository empleadoRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void crearEmpleado(EmpleadoDto empleadoDto) {
        empleadoRepository.save(modelMapper.map(empleadoDto, Empleado.class));
    }

    @Override
    public void editarEmpleado(EmpleadoDto empleadoDto) {
        String idEmpleado = empleadoDto.getId();
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElseThrow(
                () -> new NotFoundException("NO SE ENCONTRÓ AL EMPLEADO CON ID:" + idEmpleado)
        );
        empleadoRepository.save(modelMapper.map(empleadoDto, Empleado.class));
    }

    @Override
    public List<EmpleadoDto> findAllEmpleados() {
        Iterable<Empleado> empleados = empleadoRepository.findAll();
        return StreamSupport.stream(empleados.spliterator(), false)
                .map(empleado -> modelMapper.map(empleado, EmpleadoDto.class))
                .toList();
    }
}
