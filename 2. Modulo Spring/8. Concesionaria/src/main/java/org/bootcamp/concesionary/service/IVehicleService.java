package org.bootcamp.concesionary.service;

import org.bootcamp.concesionary.dto.VehicleDTO;

import java.util.Date;
import java.util.List;

public interface IVehicleService {
    List<VehicleDTO> getAllVehicles();
    VehicleDTO getVehicleById(String index);
    String addVehicle(VehicleDTO vehicle);
    List<VehicleDTO> getVehiclesBetweenDates(Date since, Date to);
    List<VehicleDTO> getVehiclesBetweenPrices(Integer since, Integer to);
}
