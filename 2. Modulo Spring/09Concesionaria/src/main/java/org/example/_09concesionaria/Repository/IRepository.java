package org.example._09concesionaria.Repository;

import org.example._09concesionaria.Model.Vehicle;

import java.util.List;

public interface IRepository {
    boolean save(Vehicle vehicle);

    List<Vehicle> findAll();
}
