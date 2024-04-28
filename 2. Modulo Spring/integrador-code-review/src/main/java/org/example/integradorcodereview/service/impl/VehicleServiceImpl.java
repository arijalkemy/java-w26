package org.example.integradorcodereview.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.integradorcodereview.dto.VehicleAvgDto;
import org.example.integradorcodereview.dto.VehicleDto;
import org.example.integradorcodereview.dto.VehicleMassiveDto;
import org.example.integradorcodereview.dto.VehicleMessageDto;
import org.example.integradorcodereview.entity.Vehicle;
import org.example.integradorcodereview.exception.ConflictException;
import org.example.integradorcodereview.exception.NotFoundException;
import org.example.integradorcodereview.repository.IVehicleRepository;
import org.example.integradorcodereview.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    IVehicleRepository vehicleRepository;

    ObjectMapper objectMapper;

    public VehicleServiceImpl(){
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicleRepo = vehicleRepository.getAllVehicle();
        List<VehicleDto> response = new ArrayList<>();

        for(Vehicle v:vehicleRepo){
            response.add(objectMapper.convertValue(v, VehicleDto.class));
        }

        if (!response.isEmpty()){
            return response;
        } else {
            throw new NotFoundException("No vehicles were found");
        }
    }

    @Override
    public VehicleDto getVehicleById(Long id) {
        return objectMapper.convertValue(vehicleRepository.getVehicleById(id), VehicleDto.class);
    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) {
        if (!vehicleRepository.vehicleExists(vehicleDto.getId())){
            Vehicle vehicle = vehicleRepository.addVehicle(objectMapper.convertValue(vehicleDto, Vehicle.class));
            return vehicleDto;
        } else {
            throw new ConflictException("Vehicle with id: " + vehicleDto.getId()+ ", already exists");
        }
    }

    private List<VehicleDto> mapSearchVehicles(List<Vehicle> vehicles){
        List<VehicleDto> response = new ArrayList<>();

        for(Vehicle v:vehicles) {
            response.add(objectMapper.convertValue(v, VehicleDto.class));
        }

        if (!response.isEmpty()) return response;
        else throw new NotFoundException("No vehicles were found with that criteria");
    }

    @Override
    public List<VehicleDto> findVehiclesColorYear(String color, Integer year) {
        List<Vehicle> vehicles = vehicleRepository.findVehiclesColorYear(color, year);
        return mapSearchVehicles(vehicles);

    }

    @Override
    public List<VehicleDto> findVehiclesBrandYearRange(String brand, Integer startYear, Integer endYear) {
        List<Vehicle> vehicles = vehicleRepository.findVehiclesBrandYearRange(brand, startYear, endYear);
        return mapSearchVehicles(vehicles);
    }

    @Override
    public VehicleAvgDto getBrandVehicleAvgSpeed(String brand) {
        return new VehicleAvgDto(
                brand,
                vehicleRepository.getAverageSpeed(brand)
        );
    }

    @Override
    public VehicleMassiveDto addMassiveVehicle(List<VehicleDto> vehicleDtoList) {
        List<Vehicle> vehiclesToAdd = new ArrayList<>();
        for (VehicleDto v: vehicleDtoList){
            addVehicle(v);
        }
        return new VehicleMassiveDto( "Successful operation", vehicleDtoList.size());
    }

    @Override
    public VehicleDto updateVehicleSpeed(Long id, VehicleDto vehicleDto) {
        if (!(vehicleDto==null)){
            Vehicle vehicle = objectMapper.convertValue(vehicleDto, Vehicle.class);
            return objectMapper.convertValue(vehicleRepository.updateVehicleSpeed(id, vehicle), VehicleDto.class);
        } else {
            throw new ConflictException("Error updating");
        }
    }

    @Override
    public List<VehicleDto> findVehicleFuelType(String fuelType) {
        List<Vehicle> response = vehicleRepository.findVehiclesFuelType(fuelType);
        return mapSearchVehicles(response);
    }

    @Override
    public List<VehicleDto> findVehicleTransmissionType(String transmissionType) {
        List<Vehicle> response = vehicleRepository.findVehiclesTransmissionType(transmissionType);
        return mapSearchVehicles(response);
    }

    @Override
    public VehicleMessageDto deleteVehicle(Long id) {
        if (vehicleRepository.vehicleExists(id)){
            vehicleRepository.deleteVehicle(id);
            return new VehicleMessageDto("Vehicle with id: " + id + "was deleted");
        } else {
            throw new NotFoundException("Vehicle do not exists");
        }
    }

    @Override
    public VehicleAvgDto getBrandVehiclePassengersAvg(String brand) {
        return new VehicleAvgDto(
                brand,
                vehicleRepository.getAveragePassengers(brand)
        );
    }

    @Override
    public List<VehicleDto> findVehiclesMeasuresRange(Double minLength, Double maxLength, Double minWidth, Double maxWidth) {
        List<Vehicle> response = vehicleRepository.findVehiclesMeasuresRange(minLength, maxLength, minWidth, maxWidth);
        return mapSearchVehicles(response);
    }

    @Override
    public List<VehicleDto> findVehiclesWeightRange(Double minWeight, Double maxWeight) {
        List<Vehicle> response = vehicleRepository.findVehiclesWeightRange(minWeight, maxWeight);
        return mapSearchVehicles(response);
    }
}
