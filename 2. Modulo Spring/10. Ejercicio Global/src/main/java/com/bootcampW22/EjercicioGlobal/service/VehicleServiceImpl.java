package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehiclesNotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchByWeight(double weightMax, double weightMin) {
        List<Vehicle> vehicleList = vehicleRepository.findAll()
            .stream().filter(v -> v.getWeight() > weightMin && v.getWeight() < weightMax).toList();


        if(vehicleList.isEmpty()) {
            throw new VehiclesNotFoundException("No se han encontrado vehiculos en ese rango");
        }

        return vehicleList.stream().map(this::vehicleToDto).toList();
    }

    public VehicleDto vehicleToDto(Vehicle vehicle) {
        return new VehicleDto(
            vehicle.getId(),
            vehicle.getBrand(),
            vehicle.getModel(),
            vehicle.getRegistration(),
            vehicle.getColor(),
            vehicle.getYear(),
            vehicle.getMax_speed(),
            vehicle.getPassengers(),
            vehicle.getFuel_type(),
            vehicle.getTransmission(),
            vehicle.getHeight(),
            vehicle.getWidth(),
            vehicle.getWeight()
        );
    }



}
