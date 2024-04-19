package org.example._09concesionaria.Repository;

import org.example._09concesionaria.Model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IRepository {
    boolean save(Vehicle vehicle);

    List<Vehicle> findAll();
    Optional<Vehicle> findById(Integer id);
}
