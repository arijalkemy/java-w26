package org.ejercicio.empleados.services.Impl;

import org.ejercicio.empleados.models.Empleado;
import org.ejercicio.empleados.repositories.IEmpleadoRepository;
import org.ejercicio.empleados.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import org.modelmapper.TypeToken;
import org.ejercicio.empleados.dtos.EmpleadoDto;
import java.util.stream.*;
import org.springframework.stereotype.Service;

/**
 * EmpleadoService
 */
@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    IEmpleadoRepository empleadoRepository;

    // Crear
    @Override
    public String crearEmpleado(EmpleadoDto empleado) {
        empleadoRepository.save(empleadoDtoToEmpleado(empleado));
        return "Se ha creado con exito el empleado ";
    }

    public Empleado empleadoDtoToEmpleado(EmpleadoDto empleado) {
        ModelMapper modelMpapper = new ModelMapper();
        return modelMpapper.map(empleado, Empleado.class);
    }

    public EmpleadoDto empleadoToEmpleadoDTO(Empleado empleado) {
        ModelMapper modelMpapper = new ModelMapper();
        return modelMpapper.map(empleado, EmpleadoDto.class);
    }

    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        Iterable<Empleado> iterEmpleados = empleadoRepository.findAll();
        Stream<Empleado> stream = StreamSupport.stream(iterEmpleados.spliterator(), false);
        return stream.map(this::empleadoToEmpleadoDTO).toList();
    }

    @Override
    public EmpleadoDto obtenerEmpleadoPorId(String id) {
        return empleadoToEmpleadoDTO(empleadoRepository.findById(id).orElseThrow(
                () -> new RuntimeException()));
    }

    @Override
    public String actualizarEmpleado(String id, EmpleadoDto empleadoDto) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);

        if (!empleado.isPresent())
            throw new RuntimeException("No se encontro empleado");

        Empleado empleadoFinal = empleadoDtoToEmpleado(empleadoDto);
        empleadoFinal.setId(id);

        return "El empleado " + id + "ha sido actualizado";

    }

}
