package org.example.ejercicio_concesionario.services;

import org.example.ejercicio_concesionario.dto.*;

import java.time.LocalDate;
import java.util.List;

public interface ICarDealershipService {
    public CarResponseDTO addCar(CarRequestDTO carRequestDTO);
    public List<CarResponseDTO> getAllCars();
    public List<CarResponseDTO> getCarsByDateRange(LocalDate since, LocalDate to);
    public List<CarResponseDTO> getCarsByPriceRange(Double priceMin, Double priceMax);
    public CarResponseDTO getCarById(Long id);
}
