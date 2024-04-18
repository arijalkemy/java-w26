package org.example.concesionariaautos.repository;

import org.example.concesionariaautos.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DealershipRepository {
    List<Car> cars = new ArrayList<>();

    public DealershipRepository() {
    }

    public List<Car> getCars() {
        return cars;
    }
}
