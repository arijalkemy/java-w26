package org.example.concesionario.service;

import org.example.concesionario.dto.ResponseVehiculeDTO;
import org.example.concesionario.entity.VehicleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IConcensionarioService {
    VehicleEntity nuevoAuto(VehicleEntity vehicle);
    List<ResponseVehiculeDTO> todosVehiculos();
    List<ResponseVehiculeDTO> vehiculosPorFecha(LocalDate since, LocalDate to);
    List<ResponseVehiculeDTO> vehiculosPorPrecio(double since, double to);
    List<ResponseVehiculeDTO> vehiculoPorId(UUID id);
}
