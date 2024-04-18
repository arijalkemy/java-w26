package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.repository;

import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepository implements IRepository<Vehicle, Integer> {

    @Override
    public Vehicle addElement(Vehicle vehicle) {
        Integer id = dataBase.getVehicles().size() + 1;
        vehicle.setId(id);
        dataBase.addVehicle(vehicle, id);
        return vehicle;
    }

    @Override
    public Map<Integer, Vehicle> getAll() {
        return dataBase.getVehicles();
    }

    @Override
    public Vehicle getById(Integer integer) {
        if (dataBase.getVehicles().containsKey(integer)) {
            return dataBase.getVehicles().get(integer);
        }
        return null;
    }

    @Override
    public List<Vehicle> getAllByForeingId(Integer integer) {
        return null;
    }
}
