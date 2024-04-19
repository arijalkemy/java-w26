package com.example.concesionaria.repositories.impl;

import com.example.concesionaria.model.Car;
import com.example.concesionaria.repositories.interfaces.ICarRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository implements ICarRepository {
    List<Car> cars = new ArrayList<>();

    @Override
    public boolean createCar(Car car) {
        cars.add(car);
        // habria que validar si existe el id, en este caso no esta contemplado
        System.out.println("---AGREGANDO AUTO---");
        System.out.println(cars);
        return true;
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> getCarsBetweenTwoDates(LocalDate since, LocalDate to) {
        return cars.stream().filter(
                c -> c.getManufacturingDate().isAfter(since)
                    && c.getManufacturingDate().isBefore(to)
        ).toList();
    }

    @Override
    public List<Car> getCarsBetweenTwoPrices(Double since, Double to) {
        return cars.stream().filter(
                c -> c.getPrice()>=since
                        && c.getPrice()<=to
        ).toList();
    }

    @Override
    public Car getById(int id) {

        Optional<Car> carOptional =
                cars.stream()
                        .filter(c -> c.getId() == id).findFirst();

        if(carOptional.isPresent()){
            return carOptional.get();
        } else{
            return null;
        }
    }
}
