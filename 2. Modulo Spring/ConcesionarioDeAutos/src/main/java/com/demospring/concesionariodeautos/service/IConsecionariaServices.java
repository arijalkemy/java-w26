package com.demospring.concesionariodeautos.service;

import com.demospring.concesionariodeautos.dto.CarDTO;
import com.demospring.concesionariodeautos.dto.CarResponseDTO;

import java.util.List;

public interface IConsecionariaServices {
    void addCar(CarDTO carDTO);
    List<CarResponseDTO> getCars();
    List<CarResponseDTO> findCarsByManufacturingDate(String since, String to);
    List<CarResponseDTO> findCarsByPrice(double since, double to);
    CarDTO findCarById(int id);
}
