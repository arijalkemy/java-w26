package org.example.concesionario.Services.impl;

import org.example.concesionario.Services.IvehicleService;
import org.example.concesionario.dto.VehicleDto;
import org.example.concesionario.dto.VehicleDtoOut;
import org.example.concesionario.model.Vehicle;
import org.example.concesionario.repositories.Impl.VehicleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements IvehicleService {

    @Autowired
    VehicleRepositoryImpl carRepo;


    public void addVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle(vehicleDto.getBrand(), vehicleDto.getModel(), vehicleDto.getManufacturing(), vehicleDto.getNumberOfKilometers(), vehicleDto.getDoors(), vehicleDto.getPrice(), vehicleDto.getCurrency(), vehicleDto.getNumberOfOwners(), vehicleDto.getService());
        this.carRepo.createVehicle(vehicle);
    }

    public List<VehicleDtoOut> findAllVehicles() {
        return convertListVehicleToListVehicleDto(this.carRepo.allVehicles());
    }

    public List<VehicleDtoOut> findVehiclesByDate(LocalDate sinceDate, LocalDate toDate) {
        List<Vehicle> listOfVehicles = this.carRepo.allVehicles().stream().filter(vehicle -> vehicle.getManufacturing().isAfter(sinceDate) && vehicle.getManufacturing().isBefore(toDate)).toList();
        return convertListVehicleToListVehicleDto(listOfVehicles);
    }

    public List<VehicleDtoOut> findVehiclesByPrice(int since, int to) {
        List<Vehicle> listOfVehicles = this.carRepo.allVehicles().stream().filter(vehicle -> vehicle.getPrice()<=to && vehicle.getPrice()>=since).toList();
        return convertListVehicleToListVehicleDto(listOfVehicles);
    }

    public VehicleDtoOut findVehiclesById(int Id) {
        Vehicle vehicle = this.carRepo.findVehicleById(Id);
        return new VehicleDtoOut(vehicle.getBrand(),vehicle.getModel(), vehicle.getManufacturing(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getNumberOfOwners());
    }

    public List<VehicleDtoOut> convertListVehicleToListVehicleDto(List<Vehicle> listOfVehicles) {
        List<VehicleDtoOut> listOfVehiclesDto = new ArrayList<>();
        for(Vehicle vehicle : listOfVehicles) {
            VehicleDtoOut vehicleDtoOut = new VehicleDtoOut(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturing(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getNumberOfOwners());
            listOfVehiclesDto.add(vehicleDtoOut);
        }
        return listOfVehiclesDto;
    }
}
