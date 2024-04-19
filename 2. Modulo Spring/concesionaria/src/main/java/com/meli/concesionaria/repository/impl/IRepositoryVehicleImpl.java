package com.meli.concesionaria.repository.impl;

import com.meli.concesionaria.entity.Vehicle;
import com.meli.concesionaria.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class IRepositoryVehicleImpl implements IRepository<Vehicle> {
    List<Vehicle> vehiclesList;

    public IRepositoryVehicleImpl() {
        this.vehiclesList = new ArrayList<>();
    }

    @Override
    public Optional<Vehicle> getById(Integer id) {
        return vehiclesList.stream()
                .filter(e->e.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Vehicle> getAll() {
        return vehiclesList;
    }

    @Override
    public Vehicle add(Vehicle data) {
         vehiclesList.add(data);
         return data;
    }
}
