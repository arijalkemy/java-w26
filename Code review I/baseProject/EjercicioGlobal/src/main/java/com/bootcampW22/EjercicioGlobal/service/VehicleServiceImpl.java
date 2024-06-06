package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public List<VehicleDto> searchAllVehiclesByLengthAndWidth(String width, String height) {
        String[] widthArray = width.split("-");
        String[] heightArray = height.split("-");

        Double minWidth = Double.valueOf(widthArray[0]);
        Double maxWidth = Double.valueOf(widthArray[1]);

        Double minHeight = Double.valueOf(heightArray[0]);
        Double maxHeight = Double.valueOf(heightArray[1]);

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> filteredVehicles = new ArrayList<>();

        filteredVehicles = vehicleList.stream().filter( v ->
               ((minWidth < v.getWidth()) && (v.getWidth() < maxWidth)) &&
               ((minHeight < v.getHeight()) && (v.getHeight() < maxHeight))
        ).collect(Collectors.toList());

        if (filteredVehicles.size() == 0) {
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }

        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> filteredVehiclesDTOs = filteredVehicles.stream().map(v ->
                mapper.convertValue(v, VehicleDto.class)
        ).collect(Collectors.toList());


        return filteredVehiclesDTOs;
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
}
