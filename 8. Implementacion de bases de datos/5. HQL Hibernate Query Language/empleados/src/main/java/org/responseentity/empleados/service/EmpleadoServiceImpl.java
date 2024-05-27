package org.responseentity.empleados.service;

import org.responseentity.empleados.domain.Empleado;
import org.responseentity.empleados.dto.EmpleadoDTO;
import org.responseentity.empleados.mapper.EmpleadoMapper;
import org.responseentity.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoDTO> listAllEmpleados() {
        return EmpleadoMapper.entitiesToDtos(empleadoRepository.findAll());
    }

    @Override
    public EmpleadoDTO getEmpleadoById(String id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if(!empleado.isPresent()){
            throw new RuntimeException("empleado not found");
        }
        return EmpleadoMapper.entityToDto(empleado.get());

    }

    @Override
    public EmpleadoDTO saveEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoRepository.save(EmpleadoMapper.dtoToEntity(empleadoDTO));
        return EmpleadoMapper.entityToDto(empleado);
    }

    @Override
    public EmpleadoDTO updateEmpleado(String id, EmpleadoDTO empleadoDTO) {
        Optional<Empleado> empleadoTemp = empleadoRepository.findById(id);
        if(!empleadoTemp.isPresent()){
            throw new RuntimeException("empleado not found");
        }
        Empleado empleado = empleadoTemp.get();
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setApellido(empleadoDTO.getApellido());
        empleado.setEdad(empleadoDTO.getEdad());
        empleado.setCiudad(empleadoDTO.getCiudad());
        empleado.setDireccion(empleadoDTO.getDireccion());

        Empleado empleadoUpdated = empleadoRepository.save(empleado);
        return EmpleadoMapper.entityToDto(empleadoUpdated);
    }

    @Override
    public void deleteEmpleado(String id) {
        empleadoRepository.deleteById(id);
    }
}
