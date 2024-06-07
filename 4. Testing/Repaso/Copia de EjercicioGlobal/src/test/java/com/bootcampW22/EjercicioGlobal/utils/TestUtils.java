package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


public class TestUtils {
    public static Vehicle mitsubishiExcelVehicleEntity() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(3L);
        vehicle.setBrand("Mitsubishi");
        vehicle.setModel("Excel");
        vehicle.setRegistration("0904");
        vehicle.setYear(1987);
        vehicle.setColor("Green");
        vehicle.setMax_speed("89");
        vehicle.setFuel_type("gas");
        vehicle.setTransmission("automatic");
        vehicle.setPassengers(5);
        vehicle.setHeight(39.18);
        vehicle.setWidth(290.82);
        vehicle.setWeight(121.17);

        return vehicle;
    }

    public static Vehicle fordFiestaVehicleEntity() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setBrand("Ford");
        vehicle.setModel("Fiesta");
        vehicle.setRegistration("6603");
        vehicle.setYear(2014);
        vehicle.setColor("Mauv");
        vehicle.setMax_speed("85");
        vehicle.setFuel_type("gasoline");
        vehicle.setTransmission("semi-automatic");
        vehicle.setPassengers(2);
        vehicle.setHeight(105.43);
        vehicle.setWidth(280.28);
        vehicle.setWeight(288.8);

        return vehicle;
    }

    public static VehicleDto fordFiestaVehicleDto() {
        Vehicle vehicleEntity = fordFiestaVehicleEntity();

        return new ObjectMapper().convertValue(vehicleEntity, VehicleDto.class);
    }

    public static List<VehicleDto> mapVehicleEntitiesToDto(List<Vehicle> vehicles) {
        return vehicles.stream().map(v -> new ObjectMapper().convertValue(v, VehicleDto.class)).toList();
    }
}
