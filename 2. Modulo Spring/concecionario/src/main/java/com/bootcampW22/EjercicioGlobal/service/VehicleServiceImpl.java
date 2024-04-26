package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.ValidationException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) throws ValidationException {
        if (vehicleRepository.existsById(vehicleDto.getId())) {
            throw new AlreadyExistsException("A vehicle with ID " + vehicleDto.getId() + " already exists.");
        }

        if (vehicleDto.getId() == null || vehicleDto.getBrand() == null || vehicleDto.getBrand().trim().isEmpty()) {
            throw new ValidationException("Datos del vehículo mal formados o incompletos.");
        }

        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        Vehicle savedVehicle = vehicleRepository.saveVehicle(vehicle);
        return mapper.convertValue(savedVehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> findVehiclesByColorAndYear(String color, int year) {
        List<Vehicle> vehicles = vehicleRepository.findByColorAndYear(color, year);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Double calculateAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findByBrand(brand);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        Double sum = 0.;
        for (Vehicle v : vehicles) {
            sum += v.getMax_speed();
        }

        return sum/vehicles.size();

    }

    @Override
    public List<VehicleDto> createVehicles(List<VehicleDto> vehicleDtos)  {
        List<VehicleDto> createdVehicles = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (VehicleDto vehicleDto : vehicleDtos) {
            if (vehicleDto.getId() == null || vehicleDto.getBrand() == null || vehicleDto.getBrand().trim().isEmpty()) {
                throw new ValidationException("Datos del vehículo mal formados o incompletos.");
            }
            if (vehicleRepository.existsById(vehicleDto.getId())) {
                throw new AlreadyExistsException("A vehicle with ID " + vehicleDto.getId() + " already exists.");
            }
            Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
            Vehicle savedVehicle = vehicleRepository.saveVehicle(vehicle);
            createdVehicles.add(mapper.convertValue(savedVehicle, VehicleDto.class));
        }
        return createdVehicles;
    }

    @Override
    public void updateVehicleSpeed(Long id, int max_speed) {
        Vehicle vehicle = vehicleRepository.findById(id);

        if (vehicle == null){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        if (!isValidSpeed(max_speed)) {
            throw new ValidationException("Velocidad mal formada o fuera de rango.");
        }

        vehicle.setMax_speed(max_speed);
        vehicleRepository.saveVehicle(vehicle);
    }

    private boolean isValidSpeed(int speed) {
        if(speed < 0){
            return false;
        }
        return true;
    }

    @Override
    public List<VehicleDto> findVehiclesByFuelType(String fuelType) {
        List<Vehicle> vehicles = vehicleRepository.findByFuelType(fuelType);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No vehicles found with fuel type: " + fuelType);
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findVehiclesByTransmission(String type) {
        List<Vehicle> vehicles = vehicleRepository.findByTransmission(type);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No vehicles found with fuel type: " + type);
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        vehicleRepository.deleteById(vehicle.getId());
    }

    @Override
    public List<VehicleDto> findVehiclesByDimensions(double min_height, double max_height, double min_width, double max_width) {
        List<Vehicle> vehicles = vehicleRepository.findByDimensions(min_height, max_height, min_width, max_width);
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }
}
