package com.ejerciciospring.concesionario.repository;

import com.ejerciciospring.concesionario.dto.CarInputDTO;
import com.ejerciciospring.concesionario.models.Car;
import com.ejerciciospring.concesionario.models.Service;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    @Getter
    private final List<Car> cars ;
    private final List<Service> services = new ArrayList<>();
    Integer idCounter = 1;


    public CarRepository() {
        this.cars = createCars();
    }
    public List<Car> createCars() {
        List<Car> carlist = new ArrayList<>();
        Service paint = new Service(LocalDate.of(2024,1,1),500,"Changed paint color");
        Service tyres = new Service(LocalDate.of(2024,4,2),1000,"Changed tyres compound");

        services.add(paint);
        services.add(tyres);
        carlist.add(new Car(1,"Aston Martin","DBX",LocalDate.of(2023,12,12),10000,5,300000.0,services,1));
        return carlist;
    }

    public void saveCar(CarInputDTO car) {
        idCounter++;
        Car carToSave = new Car(idCounter,car.getBrand(),car.getModel(),car.getManufacturingDate(),car.getNumberOfKilometers(),car.getDoors(),car.getPrice(),car.getServices(),car.getCountOfOwners());
        cars.add(carToSave);
    }
}
