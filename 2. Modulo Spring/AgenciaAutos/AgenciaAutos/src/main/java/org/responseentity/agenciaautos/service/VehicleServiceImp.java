package org.responseentity.agenciaautos.service;

import org.responseentity.agenciaautos.dto.VehicleDTOWithServices;
import org.responseentity.agenciaautos.dto.VehicleDTOWithoutServices;
import org.responseentity.agenciaautos.mapper.VehicleMapperWithServices;
import org.responseentity.agenciaautos.mapper.VehicleMapperWithoutServices;
import org.responseentity.agenciaautos.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleServiceImp implements VehicleService{
    @Autowired
    VehiculeRepository repository;

    @Override
    public List<VehicleDTOWithoutServices> getAllVehicles() {
        return repository.getAllVehicles()
                .stream()
                .map(vehicleEntity -> VehicleMapperWithoutServices.entityToDTO(vehicleEntity))
                .toList();
    }

    @Override
    public VehicleDTOWithServices getVehicleById(UUID id) {
        return VehicleMapperWithServices.entityToDTO(repository.getVehicleById(id));
    }

    @Override
    public List<VehicleDTOWithoutServices> getVehiclesByPriceRange(int priceLowRange, int priceHighRange) {
        return repository
                .filterByPriceRange(priceLowRange, priceHighRange)
                .stream()
                .map(x -> VehicleMapperWithoutServices.entityToDTO(x))
                .toList();
    }

    @Override
    public List<VehicleDTOWithoutServices> getVehiclesByDateRange(LocalDate dateLowRange, LocalDate dateHighRange) {
        return repository
                .filterByDateRange(dateLowRange, dateHighRange)
                .stream()
                .map(x -> VehicleMapperWithoutServices.entityToDTO(x))
                .toList();
    }

    @Override
    public VehicleDTOWithServices addVehicle(VehicleDTOWithServices vehicleDTOWithServices) {
        vehicleDTOWithServices.setId(UUID.randomUUID());
        repository.addVehicle(VehicleMapperWithServices.dtoToEntity(vehicleDTOWithServices));
        return vehicleDTOWithServices;
    }
}
