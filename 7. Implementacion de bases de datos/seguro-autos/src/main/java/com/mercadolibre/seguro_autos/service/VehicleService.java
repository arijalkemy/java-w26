package com.mercadolibre.seguro_autos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mercadolibre.seguro_autos.dto.ModeloDto;
import com.mercadolibre.seguro_autos.dto.PatenteMarcaDto;
import com.mercadolibre.seguro_autos.dto.PatentesDto;
import com.mercadolibre.seguro_autos.dto.SiniestroDto;
import com.mercadolibre.seguro_autos.repository.VehiclesRepository;

@Service
public class VehicleService implements IVehicleService {

    ModelMapper mapper;
    private final VehiclesRepository vehiclesRepository;
    VehicleService(VehiclesRepository _vehiclesRepository)
    {
        mapper = new ModelMapper();
        vehiclesRepository = _vehiclesRepository;
    }

    @Override
    public List<PatentesDto> getAllPatentes() {
        return vehiclesRepository.findAll()
        .stream()
        .map( vehicle -> mapper.map(vehicle, PatentesDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<PatenteMarcaDto> getAllPatentesByYear() {
        return vehiclesRepository.findAllOrderByYear()
        .stream()
        .map(vehicle -> mapper.map(vehicle, PatenteMarcaDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<PatentesDto> getAllPatentesCuatroRuedasActuales() {
        return vehiclesRepository.findAllVehiclesByRuedasMorethan4()
        .stream()
        .map(vehicle -> mapper.map(vehicle, PatentesDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<ModeloDto> findAllByPerdidaEconomica()
    {
        return vehiclesRepository.findAllByPerdidaEconomica()
        .stream()
        .map(vehicle -> mapper.map(vehicle, ModeloDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<SiniestroDto> findAllByPerdidaEconomicaExtended()
    {
        return vehiclesRepository.findAllByPerdidaEconomicaExtended()
        .stream()
        .map(siniestro -> new SiniestroDto.Builder()
            .withMarca(siniestro.getVehicle().getMarca())
            .withModelo(siniestro.getVehicle().getModelo())
            .withPerdidaEconomica(siniestro.getPerdidaEconomica())
            .build()
            )
        .toList();
    }
}
