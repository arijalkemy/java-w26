package com.ejerciciospring.concesionario.service;

import com.ejerciciospring.concesionario.dto.CarInputDTO;
import com.ejerciciospring.concesionario.dto.CarOutputDTO;
import com.ejerciciospring.concesionario.models.Car;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionService {
    public void saveCar(CarInputDTO car);
    public List<CarOutputDTO> getCarsWithoutServices();
    public Car getCarById(Integer id);
    public List<CarOutputDTO> getCarsByDate(LocalDate beginTime, LocalDate endTime);
    public List<CarOutputDTO> getCarsByPrice(Double sincePrice, Double toPrice);
}
