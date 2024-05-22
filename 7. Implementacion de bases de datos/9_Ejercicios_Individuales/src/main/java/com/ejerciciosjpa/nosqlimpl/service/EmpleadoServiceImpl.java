package com.ejerciciosjpa.nosqlimpl.service;

import com.ejerciciosjpa.nosqlimpl.domain.Empleado;
import com.ejerciciosjpa.nosqlimpl.dto.EmpleadoRequestDto;
import com.ejerciciosjpa.nosqlimpl.dto.EmpleadoResponseDto;
import com.ejerciciosjpa.nosqlimpl.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    @Autowired
    IEmpleadoRepository empleadoRepository;
    @Override
    public List<EmpleadoResponseDto> getAllEmpleados() {
        ModelMapper mapper = new ModelMapper();
        return empleadoRepository.findAll().stream().map(e->mapper.map(e, EmpleadoResponseDto.class)).toList();
    }

    @Override
    public EmpleadoResponseDto save(EmpleadoRequestDto request) {
        ModelMapper mapper = new ModelMapper();
        Empleado response = empleadoRepository.save(mapper.map(request, Empleado.class));
        return mapper.map(response,EmpleadoResponseDto.class);
    }

    @Override
    public EmpleadoResponseDto modify(String id, EmpleadoRequestDto request) {
        ModelMapper mapper = new ModelMapper();
        Empleado empleadoToUpdate = empleadoRepository.findById(id).orElse(null);
        empleadoToUpdate.setNombre(request.getNombre());
        Empleado response = empleadoRepository.save(mapper.map(request, Empleado.class));
        return mapper.map(response,EmpleadoResponseDto.class);
    }
}
