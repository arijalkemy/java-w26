package org.example.es_hib_empleados.service;

import org.example.es_hib_empleados.dtos.EmpleadoDto;
import org.example.es_hib_empleados.dtos.EmpleadoResDto;
import org.example.es_hib_empleados.dtos.MessageDto;
import org.example.es_hib_empleados.exceptions.NotFoundException;
import org.example.es_hib_empleados.model.Empleado;
import org.example.es_hib_empleados.repository.IEmpleadoRepository;
import org.example.es_hib_empleados.service.interfaces.IEmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {
    private final IEmpleadoRepository repository;

    public EmpleadoServiceImp(IEmpleadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return repository.findAll();
    }

    @Override
    public EmpleadoResDto findById(String id) {
        ModelMapper mapper = new ModelMapper();
        Optional<Empleado> foundEmpleado = repository.findById(id);
        if (foundEmpleado.isEmpty()) {
            throw new NotFoundException("Empleado no encontrado");
        }
        Empleado empleado = foundEmpleado.get();
        return mapper.map(empleado, EmpleadoResDto.class);
    }

    @Override
    public EmpleadoResDto create(EmpleadoDto newEmpleado) {
        ModelMapper mapper = new ModelMapper();
        Empleado mapEmpleado = mapper.map(newEmpleado, Empleado.class);
        Empleado created = repository.save(mapEmpleado);
        return mapper.map(created, EmpleadoResDto.class);
    }

    @Override
    public EmpleadoResDto update(String id, EmpleadoDto updatedData) {
        ModelMapper mapper = new ModelMapper();
        boolean found = repository.existsById(id);
        if (!found){
            throw new NotFoundException("No se encontro empleado para actualizar");
        }
        Empleado updatedEmpleado = mapper.map(updatedData, Empleado.class);
        updatedEmpleado.setId(id);
        Empleado result = repository.save(updatedEmpleado);
        return mapper.map(result, EmpleadoResDto.class);
    }

    @Override
    public MessageDto delete(String id) {
        boolean found = repository.existsById(id);
        if (!found){
            throw new NotFoundException("No se encontro empleado para actualizar");
        }
        repository.deleteById(id);
        return new MessageDto("Empleado borrado con exito");
    }
}
