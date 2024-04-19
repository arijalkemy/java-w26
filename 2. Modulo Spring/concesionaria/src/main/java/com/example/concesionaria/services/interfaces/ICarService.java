package com.example.concesionaria.services.interfaces;

import com.example.concesionaria.DTOs.CarDTO;
import com.example.concesionaria.DTOs.CarResponseDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface ICarService {
    public boolean createCar(CarDTO carDTO);

    public List<CarResponseDTO> getCars();

    public List<CarResponseDTO> getCarsBetweenTwoDates(LocalDate since, LocalDate to);

    public List<CarResponseDTO> getCarsBetweenTwoPrices(double since, double to);

    public CarResponseDTO getById(int id);
}
