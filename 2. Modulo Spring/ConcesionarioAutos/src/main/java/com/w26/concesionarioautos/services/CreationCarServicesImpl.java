package com.w26.concesionarioautos.services;

import com.w26.concesionarioautos.dto.CarServices;
import com.w26.concesionarioautos.dto.CreationCarResult;
import com.w26.concesionarioautos.entity.Car;
import com.w26.concesionarioautos.entity.Service;
import com.w26.concesionarioautos.repository.CarRepository;
import com.w26.concesionarioautos.repository.CarServicesRepository;
import com.w26.concesionarioautos.repository.ServicesRepository;


import java.util.List;

@org.springframework.stereotype.Service
public class CreationCarServicesImpl implements ICreationCar {

    final CarRepository carRepository;
    final ServicesRepository servicesRepositoy;
    final CarServicesRepository carServicesRepository;

    public CreationCarServicesImpl(CarRepository carRepository, ServicesRepository servicesRepositoy, CarServicesRepository carServicesRepository) {
        this.carRepository = carRepository;
        this.servicesRepositoy = servicesRepositoy;
        this.carServicesRepository = carServicesRepository;
    }

    @Override
    public CreationCarResult createCar(CarServices carServices) {
        List<Service> serviceList = carServices.getServiceList();
        Car car =  new Car(carServices.getBrand(), carServices.getModel(), carServices.getManufactoringDate(), carServices.getNumberOfKilometers(), carServices.getDoors(), carServices.getPrice(), carServices.getCurrency(), carServices.getCountOfOwners());
        carRepository.getCarList().add(car);
        carServicesRepository.getListCarServeices().add(new com.w26.concesionarioautos.entity.CarServices(car, serviceList));

        for (Service service: serviceList) {
            this.servicesRepositoy.getServiceList().add(service);
        }

        CreationCarResult result = new CreationCarResult(car.getId(), "Carro creado correctament ");
        return result;
    }
}
