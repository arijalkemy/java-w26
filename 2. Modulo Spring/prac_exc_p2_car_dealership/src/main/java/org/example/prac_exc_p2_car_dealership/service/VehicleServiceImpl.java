package org.example.prac_exc_p2_car_dealership.service;

import org.example.prac_exc_p2_car_dealership.dto.FullVehicleDTO;
import org.example.prac_exc_p2_car_dealership.dto.CarServiceDTO;
import org.example.prac_exc_p2_car_dealership.dto.SimpleVehicleDTO;
import org.example.prac_exc_p2_car_dealership.entity.Car;
import org.example.prac_exc_p2_car_dealership.entity.CarService;
import org.example.prac_exc_p2_car_dealership.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {
    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public Integer addVehicle(FullVehicleDTO vehicleData) {
        Car newCar = getCarFromDTO(vehicleData);
        vehicleRepository.createVehicle(newCar);
        return newCar.getId();
    }

    public Car getCarFromDTO(FullVehicleDTO vehicleDTO) {
        List<Integer> newServicesIds = createServices(vehicleDTO.getServices());
        int newId = vehicleRepository.getLastVehicleId() + 1;

        return new Car(
                newId,
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getManufacturingDate(),
                vehicleDTO.getNumberOfKilometers(),
                vehicleDTO.getDoors(),
                vehicleDTO.getPrice(),
                vehicleDTO.getCurrency(),
                newServicesIds,
                vehicleDTO.getCountOfOwners()
        );
    }

    public List<Integer> createServices(List<CarServiceDTO> newServicesDTO) {
        int prevId = vehicleRepository.getLastServiceId();
        List<Integer> newServiceIds;
        List<CarService> newServicesToCreate = new ArrayList<>();

        for (CarServiceDTO serviceDTO : newServicesDTO) {
            CarService newCarService = new CarService();
            prevId += 1;
            newCarService.setId(prevId);
            newCarService.setDate(serviceDTO.getDate());
            newCarService.setDescriptions(serviceDTO.getDescriptions());
            newCarService.setKilometers(serviceDTO.getKilometers());

            newServicesToCreate.add(newCarService);
        }
        newServiceIds = vehicleRepository.bulkCreateCarService(newServicesToCreate);

        return newServiceIds;
    }

    @Override
    public List<SimpleVehicleDTO> getAllVehicles() {
        return vehicleRepository.getAllVehicles().stream()
                .map(this::parseVehToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SimpleVehicleDTO> getVehiclesByDate(String since, String to) {
        Date sinceDate = new Date(since);
        Date toDate = new Date(to);
        List<Car> filteredCars = vehicleRepository.getAllVehicles().stream()
                .filter(v -> {
                    Date manDate = new Date(v.getManufacturingDate());
                    return manDate.after(sinceDate) && manDate.before(toDate);
                }).toList();
        return filteredCars.stream()
                .map(this::getFullVehDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SimpleVehicleDTO> getVehiclesByPrice(String since, String to) {
        int priceSince = Integer.parseInt(since);
        int priceTo = Integer.parseInt(to);
        List<Car> filteredCars = vehicleRepository.getAllVehicles().stream()
                .filter(v -> {
                    int currPrice = Integer.parseInt(v.getPrice());
                    return currPrice >= priceSince && currPrice <= priceTo;
                }).toList();
        return filteredCars.stream()
                .map(this::getFullVehDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FullVehicleDTO getVehicleById(Integer id) {
        Car foundCar = vehicleRepository.getVehicleById(id);
        return getFullVehDTO(foundCar);
    }

    private FullVehicleDTO getFullVehDTO(Car vehicle) {
        FullVehicleDTO vehicleDTO = new FullVehicleDTO();

        List<CarServiceDTO> serviceDTOS = vehicle.getServices().stream()
                .map(this::parseServToDTO)
                .collect(Collectors.toList());

        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setDoors(vehicle.getDoors());
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDTO.setServices(serviceDTOS);
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setCountOfOwners(vehicle.getCountOfOwners());

        return vehicleDTO;
    }

    private SimpleVehicleDTO parseVehToDTO(Car vehicle) {
        SimpleVehicleDTO vehicleDTO = new SimpleVehicleDTO();

        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setDoors(vehicle.getDoors());
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setCountOfOwners(vehicle.getCountOfOwners());

        return vehicleDTO;
    }

    private CarServiceDTO parseServToDTO(Integer serviceId) {
        CarService carService = vehicleRepository.getServiceById(serviceId);
        CarServiceDTO carServiceDTO = new CarServiceDTO();
        carServiceDTO.setId(carService.getId());
        carServiceDTO.setDate(carService.getDate());
        carServiceDTO.setDescriptions(carService.getDescriptions());
        carServiceDTO.setKilometers(carService.getKilometers());
        return carServiceDTO;
    }
}
