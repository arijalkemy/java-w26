package com.ejercicio.segurosdeautos.service.implementations;

import com.ejercicio.segurosdeautos.repository.VehicleRepository;
import com.ejercicio.segurosdeautos.service.interfaces.IVehicleService;

import java.util.List;

public class VehicleService implements IVehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<String> getAllPatents() {
        return vehicleRepository.findAllPatents();
    }
}
