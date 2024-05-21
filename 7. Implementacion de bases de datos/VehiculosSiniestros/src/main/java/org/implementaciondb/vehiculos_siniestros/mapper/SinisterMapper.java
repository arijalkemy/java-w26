package org.implementaciondb.vehiculos_siniestros.mapper;

import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterRequestDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterResponseDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterWithoutVehicleDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.vehicle.VehicleResponseDto;
import org.implementaciondb.vehiculos_siniestros.model.entity.Sinister;

public class SinisterMapper {

    public static Sinister mapToSinister(SinisterRequestDto sinisterRequestDto) {
        return Sinister.builder()
                .sinisterDate(sinisterRequestDto.getSinisterDate())
                .economicLoss(sinisterRequestDto.getEconomicLoss())
                .build();
    }

    public static SinisterResponseDto mapToSinisterResponseDto(Sinister sinister) {
        VehicleResponseDto vehicleResponseDto = VehicleResponseDto.builder()
                .id(sinister.getVehicle().getId())
                .patent(sinister.getVehicle().getPatent())
                .brand(sinister.getVehicle().getBrand())
                .model(sinister.getVehicle().getModel())
                .manufactureYear(sinister.getVehicle().getManufactureYear())
                .numberOfWheels(sinister.getVehicle().getNumberOfWheels())
                .build();
        return SinisterResponseDto.builder()
                .id(sinister.getId())
                .sinisterDate(sinister.getSinisterDate())
                .economicLoss(sinister.getEconomicLoss())
                .vehicle(vehicleResponseDto)
                .build();
    }

    public static SinisterWithoutVehicleDto mapToSinisterWithoutVehicleDto(Sinister sinister) {
        return SinisterWithoutVehicleDto.builder()
                .id(sinister.getId())
                .sinisterDate(sinister.getSinisterDate())
                .economicLoss(sinister.getEconomicLoss())
                .build();
    }

}
