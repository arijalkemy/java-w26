package com.hql.hql.service;

import com.hql.hql.DTO.VehiculoPatenteMarcaDTO;
import com.hql.hql.model.Vehiculo;
import com.hql.hql.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Override
    public List<String> findLicensePlate(  ){
        return vehiculoRepository.findLicensePlate().stream().map( v -> v.getPatente()).toList();
    }

    @Override
    public List<VehiculoPatenteMarcaDTO> findPatenteMarcaInOrder() {
        return vehiculoRepository.findVehiculoOrderByAnioFabricacion().stream().map( v -> new VehiculoPatenteMarcaDTO(v.getPatente(), v.getMarca()) ).toList();
    }

    @Override
    public List<String> findLicenseByCurrentYear() {
        List<Vehiculo> vehiculos = vehiculoRepository.findVehiculoByCurrentYearRuedas(LocalDateTime.now().getYear());
        return vehiculos.stream().map( v -> v.getPatente()).toList();
    }
}

