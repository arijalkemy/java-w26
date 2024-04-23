package com.mercadolibre.ConcecionariaAutos.service;

import com.mercadolibre.ConcecionariaAutos.dto.VehicleDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    public boolean postVehicle(VehicleDTO vehicleDTO);
    public List<VehicleDTO> getAllVehicles();
    public List<VehicleDTO> getVehiclesByManufacturingDate(LocalDate since, LocalDate to);
    public List<VehicleDTO> getVehiclesByPrice(double since, double to);
    public VehicleDTO getVehicleById(int id);
}
