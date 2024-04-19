package com.example.concesionaria.services.impl;

import com.example.concesionaria.DTOs.CarDTO;
import com.example.concesionaria.DTOs.CarResponseDTO;
import com.example.concesionaria.model.Car;
import com.example.concesionaria.repositories.interfaces.ICarRepository;
import com.example.concesionaria.services.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository carRepository;

    @Override
    public boolean createCar(CarDTO carDTO) {
        Car car = new Car(
                (int) (Math.random() * 100),
                carDTO.getBrand(),
                carDTO.getModel(),
                carDTO.getManufacturingDate(),
                carDTO.getNumberOfKilometers(),
                carDTO.getDoors(),
                carDTO.getPrice(),
                carDTO.getCurrency(),
                carDTO.getServices(),
                carDTO.getCountOfOwners()
        );
        return carRepository.createCar(car);
    }

    @Override
    public List<CarResponseDTO> getCars() {

        return carRepository
                .getCars()
                .stream().map(
                        c -> new CarResponseDTO(
                                c.getBrand(),
                                c.getModel(),
                                c.getManufacturingDate(),
                                c.getNumberOfKilometers(),
                                c.getDoors(),
                                c.getPrice(),
                                c.getCurrency(),
                                c.getCountOfOwners()
                        )
                ).toList();
    }

    public List<CarResponseDTO> getCarsBetweenTwoDates(LocalDate since, LocalDate to) {
        List<Car> cars = carRepository.getCarsBetweenTwoDates(since, to);

        return cars.stream().map(
                this::convertFrom
        ).toList();
    }

    public List<CarResponseDTO> getCarsBetweenTwoPrices(double since, double to){
        List<Car> cars = carRepository.getCarsBetweenTwoPrices(since, to);

        return cars.stream().map(
                this::convertFrom
        ).toList();
    }

    @Override
    public CarResponseDTO getById(int id) {
        return convertFrom(carRepository.getById(id));
    }

    public CarResponseDTO convertFrom(Car c) {
        return new CarResponseDTO(
                c.getBrand(),
                c.getModel(),
                c.getManufacturingDate(),
                c.getNumberOfKilometers(),
                c.getDoors(),
                c.getPrice(),
                c.getCurrency(),
                c.getCountOfOwners());
    }
}
