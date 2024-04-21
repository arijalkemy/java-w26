package org.example.ejercicio_concesionario.repository;

import org.example.ejercicio_concesionario.models.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDealershipRepository implements ICarDealershipRepository{

    List<Car> carList;

    public CarDealershipRepository() {
        carList = new ArrayList<>();
    }

    @Override
    public List<Car> findAll() {
        return carList;
    }

    @Override
    public Car findById(Long id) {
        return carList.stream()
                .filter(x->
                        x.getId()
                                .equals(id)).
                findFirst()
                .orElse(null);
    }

    @Override
    public List<Car> findByDateRange(LocalDate since, LocalDate to) {
        return carList.stream()
                .filter(x->
                        !since.isAfter(x.getManufacturingDate())
                                && !to.isBefore(x.getManufacturingDate()))
                .toList();
    }

    @Override
    public void save(Car car) {
        Long id = carList.size()+1L;
        car.setId(id);
        carList.add(car);
    }

    @Override
    public List<Car> findByPriceRange(double lower, double upper) {
        return carList.stream()
                .filter(x->
                        x.getPrice()>=lower
                                && x.getPrice()<=upper)
                .toList();
    }
}
