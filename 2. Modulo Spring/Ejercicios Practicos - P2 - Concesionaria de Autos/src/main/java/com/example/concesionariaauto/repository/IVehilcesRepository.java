package com.example.concesionariaauto.repository;

import com.example.concesionariaauto.entity.VehicleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IVehilcesRepository {
    VehicleEntity addVehicle(VehicleEntity vehicle);
    List<VehicleEntity> listVehicles();
    List<VehicleEntity> listDateVehicles(LocalDate since, LocalDate to);
    List<VehicleEntity> listPriceVehicles(int since, int to);
    VehicleEntity getVehicleById(UUID id);

}
