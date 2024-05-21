package co.com.mercadolibre.empleados.service.impl;

import co.com.mercadolibre.empleados.dto.EmpleadoDTO;
import co.com.mercadolibre.empleados.entity.Empleado;
import co.com.mercadolibre.empleados.repository.IEmpleadoRepository;
import co.com.mercadolibre.empleados.service.IEmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public EmpleadoDTO create(EmpleadoDTO empleadoDTO) {
        Empleado saved = empleadoRepository.save(modelMapper.map(empleadoDTO, Empleado.class));
        return modelMapper.map(saved, EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO update(EmpleadoDTO empleadoDTO, String id) {
        if (empleadoRepository.existsById(id)) {
            empleadoDTO.setId(id);
            Empleado updated = empleadoRepository.save(modelMapper.map(empleadoDTO, Empleado.class));
            return modelMapper.map(updated, EmpleadoDTO.class);
        }
        return null;
    }

    @Override
    public List<EmpleadoDTO> findAll() {
        return empleadoRepository.findAll().stream()
                .map(empleado -> modelMapper.map(empleado, EmpleadoDTO.class))
                .toList();
    }
}
