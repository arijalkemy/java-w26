package com.spring.concesionaria.repository;

import com.spring.concesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehiclesRepository implements ICRUD<Vehicle> {

    private List<Vehicle> vehiclesRepository;

    public VehiclesRepository(List<Vehicle> vehiclesRepository) {
        this.vehiclesRepository = new ArrayList<>();
    }

    @Override
    public void create(Vehicle obj) {
        this.vehiclesRepository.add(obj);
    }

    @Override
    public Vehicle search(Integer id) {
        return this.vehiclesRepository
                .stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Vehicle obj) {

    }

    @Override
    public void delete(Number id) {

    }

    @Override
    public List<Vehicle> getAll() {
        return this.vehiclesRepository;
    }
}
