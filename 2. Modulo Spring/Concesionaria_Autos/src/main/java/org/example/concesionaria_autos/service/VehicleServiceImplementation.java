package org.example.concesionaria_autos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.concesionaria_autos.entity.Vehicle;
import org.example.concesionaria_autos.dto.VehicleDto;
import org.example.concesionaria_autos.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VehicleServiceImplementation implements IVehicleService {
    @Autowired
    IVehicleRepository vehicleRepository;


    @Override
    public String addNewVehicle(Vehicle vehicle) {
        return vehicleRepository.addNewVehicle(vehicle);
    }

    @Override
    public List<VehicleDto> getAll() {
        ObjectMapper mapper = new ObjectMapper();



        return vehicleRepository.getAll().stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> getVehicleByPrice(int since, int to) {

        ObjectMapper mapper = new ObjectMapper();

        return vehicleRepository.findVehicleByPrice(since, to)
                .stream()
                .map( v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> getVehiclesByDate(String since, String to) {
        ObjectMapper mapper = new ObjectMapper();
        return vehicleRepository.getVehiclesByDate(since, to)
                .stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    @Override
    public VehicleDto getVehicleById(int id) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = vehicleRepository.getVehicleById(id);
        if (vehicle != null)
        {

        }
        return mapper.convertValue(vehicle, VehicleDto.class);
    }
}
