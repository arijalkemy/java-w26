package org.example.concesionariaautos.service;

import org.example.concesionariaautos.dto.CarWithoutServicesDTO;
import org.example.concesionariaautos.model.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IDealershipService {
    void createVehicle();
    Car findById(Long id);
    List<Car> findByDates(LocalDate since, LocalDate to);
    List<Car> findByPrice(double since, double to );
    List<CarWithoutServicesDTO> findAllCars();
}
