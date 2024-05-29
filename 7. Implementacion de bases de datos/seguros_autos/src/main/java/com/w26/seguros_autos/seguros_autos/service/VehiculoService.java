package com.w26.seguros_autos.seguros_autos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.seguros_autos.seguros_autos.entity.Vehiculo;
import com.w26.seguros_autos.seguros_autos.mediator.dto.PostVehiculo;
import com.w26.seguros_autos.seguros_autos.mediator.dto.SuccesfullyResponse;
import com.w26.seguros_autos.seguros_autos.mediator.projection.PatenteMarcaModelo;
import com.w26.seguros_autos.seguros_autos.repository.IVehiculoRepository;

@Service
public class VehiculoService implements IVehiculoService {
    
    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public SuccesfullyResponse createVehiculo(PostVehiculo vehiculo) {
        Vehiculo vehiculoToCreate = objectMapper.convertValue(vehiculo, Vehiculo.class);
        Vehiculo vehiculoCreated = vehiculoRepository.save(vehiculoToCreate);
        
        return SuccesfullyResponse
                .builder()
                .message("Vehiculo creado correctamente")
                    .result(vehiculoCreated)
                .build();
    }

    @Override
    public SuccesfullyResponse retriveAllVehiculo() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return SuccesfullyResponse
                .builder()
                .message("Vehiculos encontrados.")
                    .result(vehiculos)
                .build();
    }

    @Override
    public SuccesfullyResponse retrivePatenteAllVehiculo() {
        List<String> patentes = vehiculoRepository.findAllVehiculoPatente();
        return SuccesfullyResponse
                .builder()
                .message("Patentes encontradas")
                .result(patentes)
                .build();
    }

    @Override
    public SuccesfullyResponse retrivePatenteAndMarca() {
        return SuccesfullyResponse
                .builder()
                .message("Patentes y marcas obtenidas")
                .result(vehiculoRepository.getPatenteMarcaAll())
                .build();
    }

    @Override
    public SuccesfullyResponse retriePatenteByActualFabricacion() {
        return SuccesfullyResponse
                .builder()
                .message("Patentes actuales")
                .result(vehiculoRepository.findPatenteByActualAnoFabricacion())
                .build();
    }

    @Override
    public SuccesfullyResponse retriveMajorPerdidaEconomica() {
        return SuccesfullyResponse
                    .builder()
                    .message("Datos recuperados")
                    .result(vehiculoRepository.findMajorPerdidaEconomica())
                    .build();
    }

    @Override
    public SuccesfullyResponse retriveMajorPerdidaEconomicaAndTotal() {
        List<PatenteMarcaModelo> vehiculos = vehiculoRepository.findMajorPerdidaEconomica();
        Double totalPerdidad = vehiculoRepository.findMajorPerdidaEconomicaTotal();
        
        Map<String, Object> result = new HashMap<>();
        result.put("vehiculos", vehiculos);
        result.put("total_perdida", totalPerdidad);

        return SuccesfullyResponse
                    .builder()
                    .message("Datos recuperados")
                    .result(result)
                    .build();
    }
}
