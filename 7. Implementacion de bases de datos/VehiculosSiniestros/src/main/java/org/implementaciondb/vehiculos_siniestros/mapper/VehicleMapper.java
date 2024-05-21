package org.implementaciondb.vehiculos_siniestros.mapper;

import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterWithoutVehicleDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.vehicle.VehicleRequestDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.vehicle.VehicleResponseDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.vehicle.VehicleWithSinistersDto;
import org.implementaciondb.vehiculos_siniestros.model.entity.Vehicle;

import java.util.List;

public class VehicleMapper {

    public static Vehicle mapToVehicle(VehicleRequestDto vehicleRequestDto) {
        return Vehicle.builder()
                .patent(vehicleRequestDto.getPatent())
                .model(vehicleRequestDto.getModel())
                .brand(vehicleRequestDto.getBrand())
                .manufactureYear(vehicleRequestDto.getManufactureYear())
                .manufactureYear(vehicleRequestDto.getManufactureYear())
                .build();
    }

    public static VehicleResponseDto mapToVehicleResponseDto(Vehicle vehicle) {
        return VehicleResponseDto.builder()
                .id(vehicle.getId())
                .patent(vehicle.getPatent())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufactureYear(vehicle.getManufactureYear())
                .numberOfWheels(vehicle.getNumberOfWheels())
                .build();
    }

    public static VehicleWithSinistersDto mapToVehicleWithSinistersDto(Vehicle vehicle) {
        List<SinisterWithoutVehicleDto> sinisters = null;
        if (!vehicle.getSinisters().isEmpty()) {
            sinisters = vehicle.getSinisters()
                    .stream()
                    .map(SinisterMapper::mapToSinisterWithoutVehicleDto)
                    .toList();
        }
        return VehicleWithSinistersDto.builder()
                .id(vehicle.getId())
                .patent(vehicle.getPatent())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufactureYear(vehicle.getManufactureYear())
                .numberOfWheels(vehicle.getNumberOfWheels())
                .build();
    }




}
