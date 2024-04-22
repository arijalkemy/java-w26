package meli.bootcamp.concesionaria.dto.mapper;

import meli.bootcamp.concesionaria.dto.VehicleDto;
import meli.bootcamp.concesionaria.dto.VehicleServiceDto;
import meli.bootcamp.concesionaria.entity.Vehicle;

public class Mapper {
    public static VehicleDto toVehicleDto(Vehicle vehicle) {
        return VehicleDto.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufacturingDate(vehicle.getManufacturingDate())
                .numberOfKilometers(vehicle.getNumberOfKilometers())
                .doors(vehicle.getDoors())
                .price(vehicle.getPrice())
                .currency(vehicle.getCurrency())
                .countOfOwners(vehicle.getCountOfOwners())
                .build();
    }

    public static VehicleServiceDto toVehicleServiceDto(Vehicle vehicle) {
        return new VehicleServiceDto(toVehicleDto(vehicle), vehicle.getServices());
    }

    public static Vehicle toVehicle(VehicleServiceDto vehicleDto) {
        return Vehicle.builder()
                .brand(vehicleDto.getBrand())
                .model(vehicleDto.getModel())
                .manufacturingDate(vehicleDto.getManufacturingDate())
                .numberOfKilometers(vehicleDto.getNumberOfKilometers())
                .doors(vehicleDto.getDoors())
                .price(vehicleDto.getPrice())
                .currency(vehicleDto.getCurrency())
                .services(vehicleDto.getServices())
                .countOfOwners(vehicleDto.getCountOfOwners())
                .build();
    }

}
