package org.example.concesionario.Services;

import org.example.concesionario.dto.VehicleDto;
import org.example.concesionario.dto.VehicleDtoOut;

import java.time.LocalDate;
import java.util.List;

public interface IvehicleService {
    void addVehicle(VehicleDto vehicle);

    List<VehicleDtoOut> findAllVehicles();

    List<VehicleDtoOut> findVehiclesByDate(LocalDate sinceDate, LocalDate toDate);

    List<VehicleDtoOut> findVehiclesByPrice(int Price, int toPrice);

    VehicleDtoOut findVehiclesById(int Id);
    
}
