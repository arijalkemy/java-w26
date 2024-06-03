package org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.repository.Interface;

import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository {
    Boolean saveVehicle(Vehicle vehicle);
    Vehicle getVehicleById(Long id);
    List<Vehicle> selectAllVehiclesByDate(String date);
    List<Vehicle> selectAllVehiclesByPrice(Double price);
    List<Vehicle> getAllVehicles();
}
