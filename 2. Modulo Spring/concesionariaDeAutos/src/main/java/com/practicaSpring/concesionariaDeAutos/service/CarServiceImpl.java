package com.practicaSpring.concesionariaDeAutos.service;

import com.practicaSpring.concesionariaDeAutos.dto.CarInputDTO;
import com.practicaSpring.concesionariaDeAutos.dto.CarResponseDTO;
import com.practicaSpring.concesionariaDeAutos.model.Car;
import com.practicaSpring.concesionariaDeAutos.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements ICarService{
    @Autowired
    ICarRepository carRepository;

    @Override
    public void addCar(CarInputDTO car) {
        carRepository.save(car);
    }

    @Override
    public List<CarResponseDTO> getCarDTOs() {
        return carRepository.findAll().stream().map(this::createDTO).collect(Collectors.toList());
    }

    @Override
    public List<CarResponseDTO> getCarDTOsForDateRange(LocalDate from, LocalDate to) {
        return carRepository.findAll().stream()
                .filter(car -> !car.getManufacturingDate().isBefore(from) && !car.getManufacturingDate().isAfter(to))
                .map(this::createDTO).collect(Collectors.toList());
    }

    @Override
    public List<CarResponseDTO> getCarDTOsForPriceRange(Integer from, Integer to) {
        return carRepository.findAll().stream()
                .filter(car -> car.getPrice() >= from && car.getPrice() <= to)
                .map(this::createDTO).collect(Collectors.toList());
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findCarById(id);
    }

    private CarResponseDTO createDTO(Car car) {
        return new CarResponseDTO(car.getBrand(), car.getModel(),
                car.getManufacturingDate(), car.getNumberOfKilometers(), car.getDoors(), car.getPrice(),
                car.getCurrency(), car.getCountOfOwners());
    }
}
