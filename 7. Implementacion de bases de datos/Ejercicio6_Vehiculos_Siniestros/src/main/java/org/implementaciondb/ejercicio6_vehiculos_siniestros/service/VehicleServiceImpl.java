package org.implementaciondb.ejercicio6_vehiculos_siniestros.service;

import org.implementaciondb.ejercicio6_vehiculos_siniestros.exception.NotFoundException;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.mapper.SinisterMapper;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.mapper.VehicleMapper;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.sinister.SinisterWithoutVehicleDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.*;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.entity.Vehicle;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PartialVehicle;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PartialVehicleAndEconomicLoss;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PatentAndBrand;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.repository.ISinisterRepository;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.repository.IVehicleRepository;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.service.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Autowired
    private ISinisterRepository sinisterRepository;

    @Override
    public VehicleResponseDto saveVehicle(VehicleRequestDto vehicleRequestDto) {
        Vehicle vehicle = vehicleRepository.save(VehicleMapper.mapToVehicle(vehicleRequestDto));
        return VehicleMapper.mapToVehicleResponseDto(vehicle);
    }

    @Override
    public List<VehicleWithSinistersDto> findAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No hay vehículos registrados");
        }
        List<VehicleWithSinistersDto> vehicleWithSinistersDtoList = vehicles
                .stream()
                .map(VehicleMapper::mapToVehicleWithSinistersDto)
                .toList();
        vehicleWithSinistersDtoList.forEach(v -> v.setSinisters(getSinisterByVehicle(v.getId())));
        return vehicleWithSinistersDtoList;
    }

    @Override
    public VehicleWithSinistersDto findVehicleById(Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        Vehicle vehicle = vehicleOptional.orElseThrow(
                () -> new NotFoundException("No existe un vehiculo con dicho id")
        );
        VehicleWithSinistersDto vehicleWithSinistersDto = VehicleMapper.mapToVehicleWithSinistersDto(vehicle);
        vehicleWithSinistersDto.setSinisters(getSinisterByVehicle(id));
        return vehicleWithSinistersDto;
    }

    @Override
    public List<PatentDto> getAllPatents() {
        List<String> patents = vehicleRepository.findAllPatents();
        return patents.stream().map(VehicleMapper::mapToPatentDto).toList();
    }

    @Override
    public List<PatentAndBrandDto> findPatentAndBrand() {
        List<PatentAndBrand> patentAndBrands = vehicleRepository.findAllByPatentsAndBrandOrderByManufacturedYear();
        return patentAndBrands.stream().map(VehicleMapper::mapToPatentAndBrandDto).toList();
    }

    @Override
    public List<PatentDto> findAllPatentsByNumberOfWheelsAndManufacturedYear() {
        List<String> patents = vehicleRepository.findAllByPatentsByNumberOfWheelsAndManufacturedYear();
        return patents.stream().map(VehicleMapper::mapToPatentDto).toList();
    }

    @Override
    public List<PartialVehicleDto> findByEconomicLoss() {
        List<PartialVehicle> partialVehicles = vehicleRepository.findByEconomicLoss();
        return partialVehicles.stream().map(VehicleMapper::mapToPartialVehicleDto).toList();
    }

    @Override
    public List<PartialVehicleAndEconomicLossDto> findByEconomicLossDetails() {
        List<PartialVehicleAndEconomicLoss> pvae = vehicleRepository.findByEconomicLossDetails();
        return pvae.stream().map(VehicleMapper::mapToPartialVehicleDto).toList();
    }

    private List<SinisterWithoutVehicleDto> getSinisterByVehicle(Long id) {
        return sinisterRepository.findByVehicleId(id)
                .stream()
                .map(SinisterMapper::mapToSinisterWithoutVehicleDto)
                .toList();
    }

}
