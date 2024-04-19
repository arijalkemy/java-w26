package org.example.integradorconcessionaire.service.impl;

import org.example.integradorconcessionaire.dto.VehicleRequestDTO;
import org.example.integradorconcessionaire.dto.VehicleResponseDTO;
import org.example.integradorconcessionaire.dto.VehicleResponseDetailDTO;
import org.example.integradorconcessionaire.entity.Vehicle;
import org.example.integradorconcessionaire.repository.VehicleMapper;
import org.example.integradorconcessionaire.repository.VehicleRepositoryImp;
import org.example.integradorconcessionaire.service.IVehicleFilterService;
import org.example.integradorconcessionaire.service.IVehicleUsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements
        IVehicleUsedService<VehicleResponseDTO>,IVehicleFilterService<VehicleResponseDetailDTO> {

    private final VehicleRepositoryImp vehicleRepositoryImp;

    @Autowired
    public VehicleServiceImpl(VehicleRepositoryImp vehicleRepositoryImp){
        this.vehicleRepositoryImp = vehicleRepositoryImp;
    }


    public String addVehicle(VehicleRequestDTO vehicleRequestDTO){
        return vehicleRepositoryImp.add(vehicleRequestDTO);
    }

    public VehicleResponseDetailDTO retreatVehicleInfo(UUID vehicleId) {
        return vehicleRepositoryImp.retreatInfo(vehicleId);
    }


        @Override
    public List<VehicleResponseDetailDTO> getByDateRange(LocalDate start, LocalDate end) {

        List<VehicleResponseDetailDTO> vehiclesResponse = new ArrayList<>();

        for (Vehicle vehicle : vehicleRepositoryImp.getVehicleRepository()){
            if (vehicle.getManufacturingDate().isAfter(start) && vehicle.getManufacturingDate().isBefore(end)){
                VehicleResponseDetailDTO vehicleDetail = VehicleMapper.mapDetail(vehicle);
                vehiclesResponse.add(vehicleDetail);
            }
        }
        return vehiclesResponse;
    }

    @Override
    public List<VehicleResponseDetailDTO> getByPriceRange(double min, double max) {

        List<VehicleResponseDetailDTO> vehiclesResponse = new ArrayList<>();

        for (Vehicle vehicle : vehicleRepositoryImp.getVehicleRepository()){
            if (min <= vehicle.getPrice() && vehicle.getPrice() <= max){
                VehicleResponseDetailDTO vehicleDetail = VehicleMapper.mapDetail(vehicle);
                vehiclesResponse.add(vehicleDetail);
            }
        }
        return vehiclesResponse;
    }

    @Override
    public List<VehicleResponseDTO> getUsed() {
        List<VehicleResponseDTO> vehiclesResponse = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepositoryImp.getVehicleRepository()){
            if (vehicle.getCountOfOwners()>0){
                VehicleResponseDTO vehicleResponse = VehicleMapper.mapResponse(vehicle);
                vehiclesResponse.add(vehicleResponse);
            }
        }
        return vehiclesResponse;
    }
}
