package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.service.interfaces;

import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto.VehicleDTO;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto.VehicleWhitoutServiceDTO;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Vehicle;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IConcesionarioService {

    public void addVehicle(VehicleDTO vehicleDTO);
    public List<VehicleWhitoutServiceDTO> getVehicles();
    public List<VehicleDTO> getVehiclesByDate(LocalDate since, LocalDate to);
    public List<VehicleDTO> getVehiclesByPrice(double since, double to);
    public VehicleDTO getVehicleById(Integer id);

}
