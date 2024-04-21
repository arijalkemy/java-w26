package com.w26.concesionarioautos.repository;

import com.w26.concesionarioautos.entity.Car;
import com.w26.concesionarioautos.entity.CarServices;
import com.w26.concesionarioautos.entity.Service;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class CarServicesRepository {

    final CarRepository carRepository;
    final ServicesRepository servicesRepository;
    private List<CarServices> listCarServeices;

    public CarServicesRepository(CarRepository carRepository, ServicesRepository servicesRepository){
        this.carRepository = carRepository;
        this.servicesRepository = servicesRepository;
        this.listCarServeices = new ArrayList<>();
        this.load();;
    }

    public void load(){
        for (Car car: carRepository.getCarList()) {
            CarServices carServices = new CarServices();
            carServices.setCar(car);
            for (Service service: servicesRepository.getServiceList()) {
                carServices.getServiceList().add(service);
            }
        }
    }
}
