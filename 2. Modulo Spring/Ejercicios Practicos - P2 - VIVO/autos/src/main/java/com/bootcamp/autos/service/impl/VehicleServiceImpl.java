package com.bootcamp.autos.service.impl;

import com.bootcamp.autos.dto.VehicleDTO;
import com.bootcamp.autos.entity.Vehicle;
import com.bootcamp.autos.repository.VehicleRepository;
import com.bootcamp.autos.service.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    ObjectMapper mapper = new ObjectMapper();

    List<Vehicle> vehicleList;
    @Override
    public VehicleDTO save(VehicleDTO vehicleDTO) {
        vehicleRepository.save(vehicleDTO);
        return vehicleDTO;
    }

    @Override
    public List<VehicleDTO> findAll() {
        vehicleList = vehicleRepository.findAll();
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<VehicleDTO> findByProductionDate(String since,String to) {
        vehicleList = vehicleRepository.findByProductionDate(convertStringToLocalDate(since),convertStringToLocalDate(to));
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> findByPrice(Double since, Double to) {
        vehicleList = vehicleRepository.findByPrice(since,to);
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO findById(Long id) {
        return new VehicleDTO(vehicleRepository.findById(id));
    }

    private LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date);
    }

}
