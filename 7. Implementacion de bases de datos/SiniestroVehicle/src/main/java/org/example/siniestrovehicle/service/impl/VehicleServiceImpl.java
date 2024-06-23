package org.example.siniestrovehicle.service.impl;

import org.example.siniestrovehicle.repository.IVehicleRepository;
import org.example.siniestrovehicle.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class VehicleServiceImpl implements IVehicleService {
    private final IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(@Autowired IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<HashMap<String, Object>> getAllPatentes() {
        return vehicleRepository.findAllPatente();
    }

    @Override
    public List<HashMap<String, Object>> getAllPatentesMarcaOrder() {
        return vehicleRepository.findPatenteMarcaOrderByAnioFabricacion();
    }

    @Override
    public List<HashMap<String, Object>> getAllPatenteAnioFabricacion() {
        return vehicleRepository.getAllPatenteAnioFabricacion(LocalDate.now().getYear());
    }
}
