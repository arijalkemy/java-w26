package com.ejerciciospring.concesionario.service;

import com.ejerciciospring.concesionario.dto.CarInputDTO;
import com.ejerciciospring.concesionario.dto.CarOutputDTO;
import com.ejerciciospring.concesionario.models.Car;
import com.ejerciciospring.concesionario.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConcesionServiceImpl implements IConcesionService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public void saveCar(CarInputDTO car) {
        carRepository.saveCar(car);
    }

    @Override
    public List<CarOutputDTO> getCarsWithoutServices() {
        List<CarOutputDTO> carsList = new ArrayList<>();
        carRepository.getCars().stream().forEach(i -> carsList.add(new CarOutputDTO(i.getId(),i.getBrand(),i.getModel(),i.getManufacturingDate(),i.getNumberOfKilometers(),i.getDoors(),i.getPrice(),i.getCountOfOwners())));
        return carsList;
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.getCars().stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<CarOutputDTO> getCarsByDate(LocalDate beginTime, LocalDate endTime) {
        List<Car> toFormat = new ArrayList<>();
        List<CarOutputDTO> carsToReturn= new ArrayList<>();
        toFormat = carRepository.getCars().stream().filter(e->e.getManufacturingDate().isBefore(endTime) && e.getManufacturingDate().isAfter(beginTime)).toList();
        toFormat.stream().forEach(i -> carsToReturn.add(new CarOutputDTO(i.getId(),i.getBrand(),i.getModel(),i.getManufacturingDate(),i.getNumberOfKilometers(),i.getDoors(),i.getPrice(),i.getCountOfOwners())));
        return carsToReturn;
    }

    @Override
    public List<CarOutputDTO> getCarsByPrice(Double sincePrice, Double toPrice) {
        List<Car> toFormat = new ArrayList<>();
        List<CarOutputDTO> carsToReturn= new ArrayList<>();
        toFormat = carRepository.getCars().stream().filter(e->e.getPrice() >= sincePrice && e.getPrice() <= toPrice).toList();
        toFormat.stream().forEach(i -> carsToReturn.add(new CarOutputDTO(i.getId(),i.getBrand(),i.getModel(),i.getManufacturingDate(),i.getNumberOfKilometers(),i.getDoors(),i.getPrice(),i.getCountOfOwners())));
        return carsToReturn;
    }
}
