package com.mercadolibre.Empleados_NOSQL.service.implement;

import com.mercadolibre.Empleados_NOSQL.dto.EmpleadoRequestDto;
import com.mercadolibre.Empleados_NOSQL.dto.EmpleadoResponseDto;
import com.mercadolibre.Empleados_NOSQL.exception.NotFoundException;
import com.mercadolibre.Empleados_NOSQL.model.Empleado;
import com.mercadolibre.Empleados_NOSQL.repository.IEmpleadoRepository;
import com.mercadolibre.Empleados_NOSQL.service.IEmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    IEmpleadoRepository repository;

    @Override
    public EmpleadoResponseDto saveEmpleado(EmpleadoRequestDto empleado) {
        return mapper.map(
                repository.save(mapper.map(
                        empleado, Empleado.class)),EmpleadoResponseDto.class);
    }

    @Override
    public EmpleadoResponseDto updateEmpleado(String id, EmpleadoRequestDto empleado) {
        Empleado finderEmpleado = repository.findById(id).orElseThrow(
                ()-> new NotFoundException("No se encuentra al usuario registrado, valide la información.")
        );
        finderEmpleado.setNombre(empleado.getNombre());
        finderEmpleado.setApellido(empleado.getApellido());
        finderEmpleado.setEdad(empleado.getEdad());
        finderEmpleado.setCiudad(empleado.getCiudad());
        finderEmpleado.setDepartamento(empleado.getDepartamento());
        return mapper.map(
                repository.save(finderEmpleado),EmpleadoResponseDto.class);
    }

    @Override
    public List<EmpleadoResponseDto> getAllEmpleados() {
        return repository.findAll().stream()
                .map(emp -> mapper.map(emp,EmpleadoResponseDto.class)).toList();
    }

}
