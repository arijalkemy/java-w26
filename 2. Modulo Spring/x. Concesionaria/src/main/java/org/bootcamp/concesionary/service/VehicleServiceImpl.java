package org.bootcamp.concesionary.service;

import org.bootcamp.concesionary.dto.VehicleDTO;
import org.bootcamp.concesionary.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public VehicleDTO getVehicleByIndex(String index) {
        return null;
    }

    @Override
    public void addVehicle(VehicleDTO vehicle) {

    }

    @Override
    public List<VehicleDTO> filterVehiclesByManufacturingDateRange(String startDate, String endDate) {
        return List.of();
    }

    @Override
    public List<VehicleDTO> filterVehiclesByPriceRange(Integer startPrice, Integer endPrice) {
        return List.of();
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return List.of();
    }
}
