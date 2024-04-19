package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.RequestVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

public class MapVehicle {
    public  static Vehicle mapRequestDTOToVehicle(RequestVehicleDTO dto, Long id){
        return new Vehicle(id, dto.getBrand(), dto.getModel(), dto.getRegistration(), dto.getColor(), dto.getYear(),
                dto.getMax_speed(), dto.getPassengers(), dto.getFuel_type(), dto.getTransmission(), dto.getHeight(),
                dto.getWidth(), dto.getWeight());
    }
    public static VehicleDto mapDTOtoVehicle(Vehicle vehicle){
        return new VehicleDto(vehicle.getId(),vehicle.getBrand(), vehicle.getModel(), vehicle.getRegistration(),
                vehicle.getColor(), vehicle.getYear(), vehicle.getMax_speed(), vehicle.getPassengers(),
                vehicle.getFuel_type(), vehicle.getTransmission(), vehicle.getHeight()
                , vehicle.getWidth(), vehicle.getWeight());
    };


}
