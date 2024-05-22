package org.example.vehiculohql.service;

import org.example.vehiculohql.VehiculoHqlApplication;
import org.example.vehiculohql.dto.VehiculoPatenteMarcaDTO;
import org.example.vehiculohql.model.Vehiculo;
import org.example.vehiculohql.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    IVehiculoRepository vehiculoRepositroy;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<String> getAllPatentes() {
        return vehiculoRepositroy.findAllPatentes();
    }

    @Override
    public List<VehiculoPatenteMarcaDTO> getVehiculosOrdenados() {
        List<Vehiculo> vehiculos = vehiculoRepositroy.findAllOrderByAnioFabricacion();
        return vehiculos.stream()
                .map(v -> modelMapper.map(v, VehiculoPatenteMarcaDTO.class)).toList();
    }
}
