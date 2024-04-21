package com.w26.concesionarioautos.services;

import com.w26.concesionarioautos.dto.GetCarFull;
import com.w26.concesionarioautos.dto.GetCarNotServicesResult;
import com.w26.concesionarioautos.dto.GetCarServicesResult;
import com.w26.concesionarioautos.dto.GetFilterCars;
import com.w26.concesionarioautos.entity.Car;
import com.w26.concesionarioautos.entity.Service;
import com.w26.concesionarioautos.exception.NotFoundCarByFilterException;
import com.w26.concesionarioautos.repository.CarRepository;
import com.w26.concesionarioautos.repository.CarServicesRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class GetCarServicesImpl implements  IGetCarServices {

    final CarRepository carRepository;
    final CarServicesRepository carServicesRepository;

    public GetCarServicesImpl(CarRepository carRepository, CarServicesRepository carServicesRepository) {
        this.carRepository = carRepository;
        this.carServicesRepository = carServicesRepository;
    }

    @Override
    public GetFilterCars retriveCarNotServices() {
        List<Car> listCar = carRepository.getCarList();

        if (listCar.isEmpty())
            throw new NotFoundCarByFilterException("No se encontraron vehiculos filtrando por las fechas dadas");

        GetFilterCars getFilterCars = new GetFilterCars(listCar);
        return getFilterCars;
    }

    @Override
    public GetCarFull retriveCarById(Integer id) {
        List<Car> listCar = carRepository.getCarList();

        Optional<Car> optional = listCar.stream().filter(car -> car.getId() == id).findFirst();

        if (!optional.isPresent())
            throw new NotFoundCarByFilterException("No se encontro el vehiculo con el ID: " + id);

        Optional<com.w26.concesionarioautos.entity.CarServices> optional2 = carServicesRepository.getListCarServeices().stream().filter(carServices -> carServices.getCar().getId() == id).findFirst();
        List<Service> serviceList = null;
        if (optional2.isPresent())
            serviceList = optional2.get().getServiceList();

        GetCarFull getCarFull = new GetCarFull(optional.get(), serviceList);

        return getCarFull;
    }

    @Override
    public GetFilterCars retriveCarByRangeDates(LocalDate since, LocalDate to) {

        List<Car> listCarFilter = carRepository.getCarList().stream().filter(car -> since.isBefore(car.getManufactoringDate()) && to.isAfter(car.getManufactoringDate())).toList();
        if (listCarFilter.isEmpty())
            throw new NotFoundCarByFilterException("No se encontraron vehiculos filtrando por las fechas dadas");

        GetFilterCars result = new GetFilterCars(listCarFilter);
        return result;
    }

    @Override
    public GetFilterCars retriveCarByRangePrice(Double since, Double to) {
        List<Car> listCarFilter = carRepository.getCarList().stream().filter(car -> car.getPrice() >= since && car.getPrice() <= to).toList();
        if (listCarFilter.isEmpty())
            throw new NotFoundCarByFilterException("No se encontraron vehiculos filtrando por las fechas dadas");

        GetFilterCars result = new GetFilterCars(listCarFilter);
        return result;
    }
}
