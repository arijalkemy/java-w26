package org.implementaciondb.ejercicio6_vehiculos_siniestros.mapper;

import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.sinister.SinisterWithoutVehicleDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.*;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.entity.Vehicle;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PartialVehicle;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PartialVehicleAndEconomicLoss;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PatentAndBrand;

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

    public static PatentDto mapToPatentDto(String patent) {
        return PatentDto.builder()
                .patent(patent)
                .build();
    }

    public static PatentAndBrandDto mapToPatentAndBrandDto(PatentAndBrand patentAndBrand) {
        return PatentAndBrandDto.builder()
                .brand(patentAndBrand.getBrand())
                .patent(patentAndBrand.getPatent())
                .build();
    }

    public static PartialVehicleDto mapToPartialVehicleDto(PartialVehicle partialVehicle) {
        return PartialVehicleDto.builder()
                .brand(partialVehicle.getBrand())
                .patent(partialVehicle.getPatent())
                .model(partialVehicle.getModel())
                .build();
    }

    public static PartialVehicleAndEconomicLossDto mapToPartialVehicleDto(
            PartialVehicleAndEconomicLoss partialVehicleAndEconomicLoss
    ) {
        return PartialVehicleAndEconomicLossDto.builder()
                .brand(partialVehicleAndEconomicLoss.getBrand())
                .patent(partialVehicleAndEconomicLoss.getPatent())
                .model(partialVehicleAndEconomicLoss.getModel())
                .economicLoss(partialVehicleAndEconomicLoss.getEconomicLoss())
                .build();
    }

}
