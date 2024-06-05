package org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.repository;

import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.model.ServiceVehicle;
import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.model.Vehicle;
import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.repository.Interface.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository implements IVehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleRepository() {
        this.generateSampleVehicles();
    }

    @Override
    public Boolean saveVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return Boolean.TRUE;
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        Vehicle vehicle = vehicles.stream()
                .filter(v -> v.getId().hashCode() == id.hashCode())
                .findFirst().orElse(null);
        return vehicle;
    }

    @Override
    public List<Vehicle> selectAllVehiclesByDate(String date) {
        return vehicles.stream()
                .filter(v ->v.getManufacturingDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> selectAllVehiclesByPrice(Double price) {
        return vehicles.stream()
                .filter(v ->v.getPrice().doubleValue() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    private void generateSampleVehicles() {
        vehicles.add(new Vehicle(1L, "Toyota", "Corolla",
                "2018-5-15", 50000, 4,
                15000, "USD", new ArrayList<>(), 1));
        vehicles.get(0).getList()
                .add(new ServiceVehicle("2023-3-10", 5000.0, "Oil change"));

        vehicles.add(new Vehicle(2L, "Honda", "Civic",
                "2019-8-20", 40000, 4, 18000, "USD", new ArrayList<>(), 2));
        vehicles.get(1).getList()
                .add(new ServiceVehicle("2023-3-10", 5000.0, "Oil change"));

        vehicles.add(new Vehicle(3L, "Ford", "Focus",
               "2017-10-10", 60000, 4, 12000, "USD", new ArrayList<>(), 1));
        vehicles.get(2).getList()
                .add(new ServiceVehicle("2023-3-10", 5000.0, "Oil change"));

    }
}
