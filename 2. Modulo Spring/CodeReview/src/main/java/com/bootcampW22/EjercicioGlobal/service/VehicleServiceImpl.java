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
    public List<VehicleDto> getVehiclesByLengthAndWidth(String lenght, String width) {
        String[] len = lenght.split("-");
        String[] wid = width.split("-");

        Double lenMin = Double.parseDouble(len[0]);
        Double lenMax = Double.parseDouble(len[1]);

        Double widthMin = Double.parseDouble(wid[0]);
        Double widthMax = Double.parseDouble(wid[1]);

        List<Vehicle> vehicles = vehicleRepository.findAll()
                .stream()
                .filter(vehicle -> (vehicle.getHeight() >= lenMin && vehicle.getHeight() <= lenMax)
                && (vehicle.getWidth() >= widthMin && vehicle.getWidth() <= widthMax))
                .toList();

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron autos con los parametros solicitados.");
        }

        return vehicleListToDtos(vehicles);
    }

    private List<VehicleDto> vehicleListToDtos(List<Vehicle> vehicles){
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            vehicleDtos.add(mapper.convertValue(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }
}
