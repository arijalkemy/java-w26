package co.com.mercadolibre.autos.repository;

import co.com.mercadolibre.autos.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    void save(Vehicle vehicle);
    Vehicle findById(Integer id);
    List<Vehicle> findAll();
}
