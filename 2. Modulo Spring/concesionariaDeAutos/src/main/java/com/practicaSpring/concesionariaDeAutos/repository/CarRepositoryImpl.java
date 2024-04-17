package com.practicaSpring.concesionariaDeAutos.repository;

import com.practicaSpring.concesionariaDeAutos.dto.CarInputDTO;
import com.practicaSpring.concesionariaDeAutos.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CarRepositoryImpl implements ICarRepository{
    private List<Car> cars;
    private Long id = 0L;

    public CarRepositoryImpl() {
        cars = new ArrayList<Car>();
    }

    @Override
    public List<Car> findAll() {
        return this.cars;
    }

    @Override
    public void save(CarInputDTO car) {
        this.cars.add(new Car(id, car.getBrand(), car.getModel(), car.getManufacturingDate(),
                car.getNumberOfKilometers(), car.getDoors(), car.getPrice(), car.getCurrency(), car.getServices(),
                car.getCountOfOwners()));
        id += 1;
    }

    @Override
    public Car findCarById(Long id) {
        return this.cars.stream().filter(car -> Objects.equals(car.getId(), id)).findFirst().orElse(null);
    }
}
