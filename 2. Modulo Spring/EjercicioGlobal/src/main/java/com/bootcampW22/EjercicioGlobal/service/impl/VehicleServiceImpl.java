package com.bootcampW22.EjercicioGlobal.service.impl;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

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
                .toList();
    }

    @Override
    public VehicleDto getAverageVehiclesByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findByBrand(brand);

        if (vehicleList.isEmpty())
            throw new NotFoundException("No se encontraron vehículos de esa marca.");

        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setAverage(vehicleList.stream().mapToDouble(Vehicle::getPassengers)
                .average()
                .orElse(0.0D));
        return vehicleDto;
    }
}
