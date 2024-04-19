package com.example.concesionaria.repositories.interfaces;


import com.example.concesionaria.model.Car;

import java.time.LocalDate;
import java.util.List;

public interface ICarRepository {
    public boolean createCar(Car car);

    public List<Car> getCars();

    public List<Car> getCarsBetweenTwoDates(LocalDate since, LocalDate to);

    public List<Car> getCarsBetweenTwoPrices(Double since, Double to);

    public Car getById(int id);

}

