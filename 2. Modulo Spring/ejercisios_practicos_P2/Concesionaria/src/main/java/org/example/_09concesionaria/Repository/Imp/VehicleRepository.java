package org.example._09concesionaria.Repository.Imp;

import org.example._09concesionaria.Model.Vehicle;
import org.example._09concesionaria.Repository.IRepository;
import org.example._09concesionaria.util.findinobject.FindByRangeUtil;
import org.example._09concesionaria.util.findinobject.FindObjectUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository implements IRepository {

    private List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public boolean save(Vehicle vehicle) {
        vehicle.setId(vehicles.size());
        return vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public Optional<Vehicle> findById(Integer id) {
        return FindObjectUtil.findByInteger(id, vehicles, Vehicle::getId);
    }

}

