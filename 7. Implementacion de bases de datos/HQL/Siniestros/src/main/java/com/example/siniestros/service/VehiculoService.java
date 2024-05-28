package com.example.siniestros.service;

import com.example.siniestros.dto.PatenteDto;
import com.example.siniestros.dto.PatenteMarcaDto;
import com.example.siniestros.dto.PatenteMarcaModeloDto;
import com.example.siniestros.model.Vehiculo;
import com.example.siniestros.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {
    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<PatenteDto> getAllPatentes() {
        return vehiculoRepository.findAll().stream()
                .map(v -> new PatenteDto(v.getPatente()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatenteMarcaDto> getAllPatenteMarcaOrderByAnio() {
        List<Vehiculo> vehiculoListOrdered = vehiculoRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getAnioFabricacion))
                .toList();

        return vehiculoListOrdered.stream().map(v -> new PatenteMarcaDto(v.getPatente(), v.getMarca()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatenteDto> getAllPatenteFourWheelsAndCurrentYear() {
        return vehiculoRepository.findAll()
                .stream()
                .filter(v -> v.getCantidadRuedas() > 4)
                .filter(v -> v.getAnioFabricacion().equals(LocalDate.now().getYear()))
                .map(v -> new PatenteDto(v.getPatente()))
                .collect(Collectors.toList());
    }

    public List<PatenteMarcaModeloDto> getAllVehiclesWithSinistes() {
        return vehiculoRepository.getVehiculoWithSinister()
                .stream()
                .map(v -> new PatenteMarcaModeloDto(v.getPatente(), v.getMarca(), v.getModelo()))
                .collect(Collectors.toList());
    }

}

