package org.example.prac_exc_p2_car_dealership.repository;

import org.example.prac_exc_p2_car_dealership.entity.Car;
import org.example.prac_exc_p2_car_dealership.entity.CarService;

import java.util.List;

public interface IVehicleRepository {
    public List<Car> getAllVehicles();

    public Car createVehicle(Car vehicle);
    public CarService createCarService(CarService service);
    public List<Integer> bulkCreateCarService(List<CarService> serviceList);
    public Integer getLastVehicleId();
    public Integer getLastServiceId();
    public List<CarService> getAllServices();
    public CarService getServiceById(Integer id);
    public Car getVehicleById(Integer id);
}
