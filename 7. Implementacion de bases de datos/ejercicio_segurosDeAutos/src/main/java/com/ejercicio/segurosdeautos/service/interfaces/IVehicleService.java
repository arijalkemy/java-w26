package com.ejercicio.segurosdeautos.service.interfaces;

import com.ejercicio.segurosdeautos.DTO.VehicleDTO;
import com.ejercicio.segurosdeautos.proyections.VehicleProjections;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IVehicleService {
    List<VehicleDTO> findVehiclesByEchonomicLostGreatherThan();
    List<VehicleDTO> findVehiclesByEchonomicLost();
    List<VehicleDTO> findAllPatents();
    List<VehicleDTO> findAllVehiclesOrderByFabricationYear();
    List<VehicleDTO> findPatentsByWheelsAndYear();
}