package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ResponseEntity<?> searchVehiclesByDimentions(Double min_height, Double max_height, Double min_width, Double max_width) {
        List<Vehicle> result = vehicleRepository.findVehiclesByDimentions(min_height, max_height, min_width, max_width);
        List<VehicleDto> vehicles = new ArrayList<>();
        if (result.size() > 0) {
            for(Vehicle v: result){
                vehicles.add(new VehicleDto(v.getId(),
                        v.getBrand(),
                        v.getModel(),
                        v.getRegistration(),
                        v.getColor(),
                        v.getYear(),
                        v.getMax_speed(),
                        v.getPassengers(),
                        v.getFuel_type(),
                        v.getTransmission(),
                        v.getHeight(),
                        v.getWidth(),
                        v.getWeight()));
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }else{
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones");
        }
    }
}
