package org.example.ejercicio_concesionarios.service;

import org.example.ejercicio_concesionarios.dto.CarRequestDTO;
import org.example.ejercicio_concesionarios.dto.CarResponseDTO;

import java.time.LocalDate;
import java.util.*;

public interface IVehicleService {
    public CarRequestDTO addCar(CarRequestDTO carRequestDTO);
    public List<CarResponseDTO> getAllCars();
    public List<CarResponseDTO> getCarsByDateRange(LocalDate since, LocalDate to);
    public List<CarResponseDTO> getCarsByPriceRange(Double priceMin, Double priceMax);
}
