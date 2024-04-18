package org.example.prac_exc_p2_car_dealership.service;

import org.example.prac_exc_p2_car_dealership.dto.FullVehicleDTO;
import org.example.prac_exc_p2_car_dealership.dto.CarServiceDTO;
import org.example.prac_exc_p2_car_dealership.dto.SimpleVehicleDTO;
import org.example.prac_exc_p2_car_dealership.entity.Car;
import org.example.prac_exc_p2_car_dealership.entity.CarService;
import org.example.prac_exc_p2_car_dealership.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
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
        int newId = vehicleRepository.getAllVehicles().size() + 1;

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
        int prevId = vehicleRepository.getAllServices().size();
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
        // TODO: Return the list of vehicles filtered by a range of dates
        return null;
    }

    @Override
    public List<SimpleVehicleDTO> getVehiclesByPrice(String since, String to) {
        // TODO: Return the list of vehicles filtered by a range of prices
        return null;
    }

    @Override
    public FullVehicleDTO getVehicleById(String id) {
        // TODO: Return a single vehicle filtered by its id
        return null;
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

    private CarServiceDTO parseServToDTO(CarService service) {
//        List<Integer> serviceIds = vehicle.getServices();
//        List<CarServiceDTO> serviceDTOS = serviceIds.stream()
//                .map(id -> vehicleRepository.getServiceById(id))
//                .map(this::parseServToDTO)
//                .toList();
        CarServiceDTO carServiceDTO = new CarServiceDTO();
        return carServiceDTO;
    }
}
