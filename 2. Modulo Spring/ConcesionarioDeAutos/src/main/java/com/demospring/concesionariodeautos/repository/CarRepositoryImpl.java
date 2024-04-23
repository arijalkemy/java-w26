package com.demospring.concesionariodeautos.repository;

import com.demospring.concesionariodeautos.dto.CarDTO;
import com.demospring.concesionariodeautos.dto.ServiceDTO;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CarRepositoryImpl implements ICarRepository{
    private List<CarDTO> cars = new ArrayList<>();

    public CarRepositoryImpl(List<CarDTO> cars) {
        generateCars();
    }

    private void generateCars(){
        List<ServiceDTO> services = new ArrayList<>();
        services.add(new ServiceDTO("2023-01-10", 10000, "Cambio de aceite"));
        services.add(new ServiceDTO("2023-07-15", 20000, "Cambio de frenos"));

        for (int i = 0; i < 10; i++) {
            cars.add(new CarDTO(
                    "Marca" + (i + 1),
                    "Modelo" + (i + 1),
                    "2022-01-01",
                    50000 + (i * 1000),
                    4,
                    15000.0 + (i * 1000),
                    "USD",
                    services,
                    2
            ));
        }
    }

    @Override
    public void addCar(CarDTO carDTO) {
        cars.add(carDTO);
    }

    @Override
    public List<CarDTO> getCars() {
        return cars;
    }

    @Override
    public List<CarDTO> findCarsByManufacturingDate(String since, String to) {
        return this.cars.stream().filter(car -> (convertStringToDate(car.getManufacturingDate()).isAfter(convertStringToDate(since)) || convertStringToDate(car.getManufacturingDate()).isEqual(convertStringToDate(since)))
                && (convertStringToDate(car.getManufacturingDate()).isBefore(convertStringToDate(since)) || convertStringToDate(car.getManufacturingDate()).isEqual(convertStringToDate(since)))).toList();
    }

    @Override
    public List<CarDTO> findCarsByPrice(double since, double to) {
        return this.cars.stream().filter(car -> car.getPrice() >= since && car.getPrice() >= to).toList();
    }

    @Override
    public CarDTO findCarById(int id) {
        return this.cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }

    private LocalDate convertStringToDate(String dateString){
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
