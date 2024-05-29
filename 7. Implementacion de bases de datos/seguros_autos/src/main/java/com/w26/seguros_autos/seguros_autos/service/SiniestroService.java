package com.w26.seguros_autos.seguros_autos.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.seguros_autos.seguros_autos.entity.Siniestro;
import com.w26.seguros_autos.seguros_autos.entity.Vehiculo;
import com.w26.seguros_autos.seguros_autos.mediator.dto.PostSiniestro;
import com.w26.seguros_autos.seguros_autos.mediator.dto.SuccesfullyResponse;
import com.w26.seguros_autos.seguros_autos.mediator.projection.SimpleSiniestro;
import com.w26.seguros_autos.seguros_autos.repository.ISiniestroRepository;
import com.w26.seguros_autos.seguros_autos.repository.IVehiculoRepository;

@Service
public class SiniestroService implements ISiniestroService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ISiniestroRepository siniestroRepository;

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Override
    public SuccesfullyResponse createSiniestro(Long idVehiculo, PostSiniestro siniestro) {
    
        Optional<Vehiculo> optional = vehiculoRepository.findById(idVehiculo);
        
        if (optional.isEmpty()) {
            throw new RuntimeException("No se encontro el vehiculo al cual se le quiere asignar el siniestro");
        }

        Siniestro siniestroToCreate = objectMapper.convertValue(siniestro, Siniestro.class);
        siniestroToCreate.setVehiculo(optional.get());
        
        Siniestro siniestroCreated = siniestroRepository.save(siniestroToCreate);
        return SuccesfullyResponse
                .builder()
                .message("Siniestro creado")
                .result(siniestroCreated)
                .build();
    }

    @Override
    public SuccesfullyResponse retriveAllSiniestro() {
        List<SimpleSiniestro> siniestros = siniestroRepository.findAllSimpleSiniestro();
        return SuccesfullyResponse
                .builder()
                .message("Siniestros encontrados")
                .result(siniestros)
                .build();
    }
    
}
