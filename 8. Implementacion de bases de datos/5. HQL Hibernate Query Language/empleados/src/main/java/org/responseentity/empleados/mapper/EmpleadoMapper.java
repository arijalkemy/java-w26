package org.responseentity.empleados.mapper;

import org.responseentity.empleados.domain.Empleado;
import org.responseentity.empleados.dto.EmpleadoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpleadoMapper {
    public static EmpleadoDTO entityToDto(Empleado empleado) {
        return EmpleadoDTO.builder()
                .id(empleado.getId())
                .nombre(empleado.getNombre())
                .apellido(empleado.getApellido())
                .edad(empleado.getEdad())
                .ciudad(empleado.getCiudad())
                .direccion(empleado.getDireccion())
                .build();
    }

    public static Empleado dtoToEntity(EmpleadoDTO empleadoDTO) {
        return Empleado.builder()
                .id(empleadoDTO.getId())
                .nombre(empleadoDTO.getNombre())
                .apellido(empleadoDTO.getApellido())
                .edad(empleadoDTO.getEdad())
                .ciudad(empleadoDTO.getCiudad())
                .direccion(empleadoDTO.getDireccion())
                .build();
    }

    public static List<EmpleadoDTO> entitiesToDtos(List<Empleado> empleados) {
        return empleados.stream()
                .map(empleado -> entityToDto(empleado))
                .collect(Collectors.toList());
    }

    public static List<Empleado> dtosToEntities(List<EmpleadoDTO> empleadoDTOs) {
        return empleadoDTOs.stream()
                .map(empleadoDTO -> dtoToEntity(empleadoDTO))
                .collect(Collectors.toList());
    }
}
