package com.demospring.concesionariodeautos.repository;

import com.demospring.concesionariodeautos.dto.CarDTO;
import com.demospring.concesionariodeautos.dto.CarResponseDTO;

import java.util.List;

public interface ICarRepository {
    void addCar(CarDTO carDTO);
    List<CarDTO> getCars();
    List<CarDTO> findCarsByManufacturingDate(String since, String to);
    List<CarDTO> findCarsByPrice(double since, double to);
    CarDTO findCarById(int id);
}
