package co.com.mercadolibre.autos.repository.impl;

import co.com.mercadolibre.autos.entity.Vehicle;
import co.com.mercadolibre.autos.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {

    private List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void save(Vehicle vehicle) {
         this.vehicles.add(vehicle);
    }

    @Override
    public Vehicle findById(Integer id) {
        return vehicles.get(id);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }
}
