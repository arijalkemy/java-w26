package org.example.prac_exc_p2_car_dealership.repository;

import org.example.prac_exc_p2_car_dealership.entity.Car;
import org.example.prac_exc_p2_car_dealership.entity.CarService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{
    private List<Car> vehicleList;
    private List<CarService> serviceList;

    public VehicleRepositoryImpl() {
        this.vehicleList = new ArrayList<>();
        this.serviceList = new ArrayList<>();
    }

    @Override
    public List<Car> getAllVehicles() {
        return this.vehicleList;
    }

    @Override
    public Car createVehicle(Car vehicle) {
        this.vehicleList.add(vehicle);
        return vehicle;
    }

    @Override
    public CarService createCarService(CarService service) {
        this.serviceList.add(service);
        return service;
    }

    @Override
    public List<Integer> bulkCreateCarService(List<CarService> serviceList) {
        this.serviceList.addAll(serviceList);
        return serviceList.stream()
                .mapToInt(CarService::getId)
                .boxed().toList();
    }

    @Override
    public List<CarService> getAllServices() {
        return this.serviceList;
    }

    @Override
    public CarService getServiceById(Integer id) {
        return this.serviceList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
