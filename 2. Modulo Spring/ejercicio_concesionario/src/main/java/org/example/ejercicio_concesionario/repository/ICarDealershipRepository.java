package org.example.ejercicio_concesionario.repository;

import org.example.ejercicio_concesionario.models.Car;

import java.time.LocalDate;
import java.util.List;

public interface ICarDealershipRepository {
    public List<Car> findAll();
    public Car findById(Long id);
    public List<Car> findByDateRange(LocalDate since, LocalDate to);
    public void save(Car car);
    public List<Car> findByPriceRange(double lower, double upper);

}
