package org.implementaciondb.vehiculos_siniestros.service;

import org.implementaciondb.vehiculos_siniestros.exception.NotFoundException;
import org.implementaciondb.vehiculos_siniestros.mapper.SinisterMapper;
import org.implementaciondb.vehiculos_siniestros.mapper.VehicleMapper;
import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterWithoutVehicleDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.vehicle.*;
import org.implementaciondb.vehiculos_siniestros.model.entity.Vehicle;
import org.implementaciondb.vehiculos_siniestros.model.projections.VehicleProjection;
import org.implementaciondb.vehiculos_siniestros.repository.ISinisterRepository;
import org.implementaciondb.vehiculos_siniestros.repository.IVehicleRepository;
import org.implementaciondb.vehiculos_siniestros.service.interfaces.IVehicleService;
import org.modelmapper.ModelMapper;
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

    ModelMapper mapper = new ModelMapper();

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
    public List<String> getAllPatents() {
        return vehicleRepository.findPatents();
    }

    @Override
    public List<VehicleQueriesDTO> findPatentAndBrand() {

        return vehicleRepository.findPatentAndBrand()
                .stream().map(x -> mapper.map(x, VehicleQueriesDTO.class)).toList();


    }


    @Override
    public List<String> findAllPatentsByNumberOfWheelsAndManufacturedYear() {
        return vehicleRepository.findAllPatentsByNumberOfWheelsAndManufacturedYear();
    }

    @Override
    public List<VehicleQueriesDTO> getLostMoreThan10000() {
        return vehicleRepository.findByEconomicLoss().stream()
                .map(x -> mapper.map(x, VehicleQueriesDTO.class)).toList();
    }

    @Override
    public VehiclesSinistersWithTotalLossDTO getEconomicLossDetails() {
        List<VehicleProjection> projections = vehicleRepository.getEconomicLossDetails();

        return new VehiclesSinistersWithTotalLossDTO(projections.stream()
                .map(x -> mapper.map(x, VehicleQueriesDTO.class)).toList(),

                projections.stream().mapToDouble(VehicleProjection::getEconomicLoss).sum());
    }

    private List<SinisterWithoutVehicleDto> getSinisterByVehicle(Long id) {
        return sinisterRepository.findByVehicleId(id)
                .stream()
                .map(SinisterMapper::mapToSinisterWithoutVehicleDto)
                .toList();
    }

}
