package org.example.integradorconcessionaire.repository;

import org.example.integradorconcessionaire.dto.VehicleResponseDTO;
import org.example.integradorconcessionaire.dto.VehicleResponseDetailDTO;
import org.example.integradorconcessionaire.entity.Vehicle;


public class VehicleMapper {

    public static VehicleResponseDetailDTO mapDetail(Vehicle vehicle){
        VehicleResponseDetailDTO vehicleDetail = new VehicleResponseDetailDTO(
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getVehicleServices(),
                vehicle.getCountOfOwners()
        );
        return vehicleDetail;
    }

    public static VehicleResponseDTO mapResponse(Vehicle vehicle){
        VehicleResponseDTO vehicleResponse = new VehicleResponseDTO(
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners()
        );
        return vehicleResponse;
    }
}
