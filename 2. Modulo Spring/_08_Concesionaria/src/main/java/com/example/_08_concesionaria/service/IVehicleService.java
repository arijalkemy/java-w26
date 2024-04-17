package com.example._08_concesionaria.service;

import com.example._08_concesionaria.dto.VehicleDTO;

import java.util.Date;
import java.util.List;

public interface IVehicleService {
    boolean addVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAll();
    List<VehicleDTO> getBetweenDates(Date dateSince, Date dateTo);
    List<VehicleDTO> getBetweenPrices(double priceSince, double priceTo);
    VehicleDTO getVehicle(String brand);
}
