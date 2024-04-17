package com.practicaSpring.concesionariaDeAutos.service;

import com.practicaSpring.concesionariaDeAutos.dto.CarInputDTO;
import com.practicaSpring.concesionariaDeAutos.dto.CarResponseDTO;
import com.practicaSpring.concesionariaDeAutos.model.Car;

import java.time.LocalDate;
import java.util.List;

public interface ICarService {

    void addCar(CarInputDTO car);

    List<CarResponseDTO> getCarDTOs();

    List<CarResponseDTO> getCarDTOsForDateRange(LocalDate from, LocalDate to);

    List<CarResponseDTO> getCarDTOsForPriceRange(Integer from, Integer to);

    Car getCarById(Long id);
}
