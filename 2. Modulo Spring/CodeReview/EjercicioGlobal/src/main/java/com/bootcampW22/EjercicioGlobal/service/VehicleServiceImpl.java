package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.InvalidDataException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.VehicleValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createVehicle(VehicleDto vehicleDto) {
        if (!VehicleValidator.verifyData(vehicleDto)) {
            throw new InvalidDataException("Datos del vehículo mal formados o incompletos.");
        }
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        if (!vehicleRepository.save(vehicle)) {
            throw new ConflictException("Identificador del vehículo ya existente.");
        }
    }

    @Override
    public List<VehicleDto> getVehiclesByColorAndYear(String color, String year) {
        if (!year.matches("\\d+")) {
            throw new InvalidDataException("El dato de año debe ser numérico.");
        }
        int y = Integer.parseInt(year);
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles = vehicles.stream()
                .filter(x -> x.getColor().toLowerCase().equals(color.toLowerCase()) && x.getYear() == y)
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDtos.add(mapper.convertValue(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> getVehiclesByColorAndYearRange(String color, String startYear, String endYear) {
        if (!startYear.matches("\\d+") || !endYear.matches("\\d+")) {
            throw new InvalidDataException("Los datos de año deben ser numéricos.");
        }
        int since = Integer.parseInt(startYear);
        int to = Integer.parseInt(endYear);
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles = vehicles.stream().filter(x -> x.getColor().toLowerCase().equals(color.toLowerCase())
                && x.getYear() >= since && x.getYear() <= to).toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDtos.add(mapper.convertValue(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }

    @Override
    public AverageResponseDto getAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles = vehicles.stream().filter(x -> x.getBrand().toLowerCase().equals(brand.toLowerCase())).toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        double averageSpeed = vehicles.stream()
                .mapToDouble(x -> Double.parseDouble(x.getMax_speed()))
                .average()
                .orElse(0.0);
        return new AverageResponseDto(averageSpeed);
    }

    @Override
    public void createVehicles(List<VehicleDto> vehicleDtos) {
        if (vehicleDtos.isEmpty()) {
            throw new InvalidDataException("No existen datos para agregar.");
        }
        for (VehicleDto vehicleDto : vehicleDtos) {
            if (!VehicleValidator.verifyData(vehicleDto)) {
                System.out.println(vehicleDto.toString());
                throw new InvalidDataException("Datos de algún vehículo mal formados o incompletos.");
            }
        }
        List<Vehicle> vehicles = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (VehicleDto vehicleDto : vehicleDtos) {
            Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
            vehicles.add(vehicle);
            if (vehicleRepository.exist(vehicle.getId())) {
                throw new ConflictException("Algún vehículo tiene un identificador ya existente.");
            }
        }
        for (Vehicle vehicle : vehicles) {
            vehicleRepository.save(vehicle);
        }
    }

    @Override
    public void updateMaxSpeed(String id, String maxSpeed) {
        if (!id.matches("\\d+")) {
            throw new InvalidDataException("Id Invalido");
        }
        Long vehicleId = Long.parseLong(id);
        if (!VehicleValidator.validateMaxSpeed(maxSpeed)) {
            throw new InvalidDataException("Velocidad mal formada o fuera de rango.");
        }
        Vehicle vehicle = vehicleRepository.getById(vehicleId);
        if (vehicle == null) {
            throw new NotFoundException("No se encontró el vehículo.");
        }
        vehicle.setMax_speed(maxSpeed);
        vehicleRepository.updateVehicle(vehicle);
    }

    @Override
    public List<VehicleDto> getVehiclesByFuelType(String fuelType) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles = vehicles.stream()
                .filter(x -> x.getFuel_type().toLowerCase().equals(fuelType.toLowerCase()))
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Vehicle vehicle : vehicles) {
            vehicleDtos.add(mapper.convertValue(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }

    @Override
    public void deleteVehicle(String id) {
        if (!id.matches("\\d+")) {
            throw new InvalidDataException("Id no valido");
        }
        if (!vehicleRepository.deleteVehicle(Long.parseLong(id))) {
            throw new NotFoundException("No se encontró el vehículo.");
        }
    }

    @Override
    public List<VehicleDto> getVehiclesByTransmissionType(String type) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles = vehicles.stream()
                .filter(x -> x.getTransmission().toLowerCase().equals(type.toLowerCase()))
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        }
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Vehicle vehicle : vehicles) {
            vehicleDtos.add(mapper.convertValue(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }

    @Override
    public void updateFuelType(String id, String type) {
        if (!id.matches("\\d+")) {
            throw new InvalidDataException("Id no valido");
        }
        if (type.isEmpty()) {
            throw new InvalidDataException("Tipo de combustible mal formado o no admitido.");
        }
        Vehicle vehicle = vehicleRepository.getById(Long.parseLong(id));
        if (vehicle == null) {
            throw new NotFoundException("No se encontró el vehículo.");
        }
        vehicle.setFuel_type(type);
        vehicleRepository.updateVehicle(vehicle);
    }

    @Override
    public AverageResponseDto getAverageCapacityByBrand(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles = vehicles.stream().filter(x -> x.getBrand().toLowerCase().equals(brand.toLowerCase())).toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        double average = vehicles
                .stream()
                .mapToDouble(x -> x.getPassengers())
                .average()
                .orElse(0.0);
        return new AverageResponseDto(average);
    }

    @Override
    public List<VehicleDto> getVehiclesByDimensions(
            String minLength, String maxLength, String minWidth, String maxWidth
    ) {
        Double minL = VehicleValidator.getDouble(minLength);
        Double maxL = VehicleValidator.getDouble(maxLength);
        Double minW = VehicleValidator.getDouble(minWidth);
        Double maxW = VehicleValidator.getDouble(maxWidth);
        if (minL == null || maxL == null || minW == null || maxW == null){
            throw new InvalidDataException("Dimenesiones mal formadas o fuera de rango.");
        }
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles = vehicles
                .stream()
                .filter(x -> x.getHeight() >= minL && x.getHeight() <= maxL
                        && x.getWidth() >= minW && x.getWidth() <= maxW)
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDtos.add(mapper.convertValue(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> getVehiclesByWeightRange(String minWeight, String maxWeight) {
        Double minW = VehicleValidator.getDouble(minWeight);
        Double maxW = VehicleValidator.getDouble(maxWeight);
        if (minW == null || maxW == null) {
            throw new InvalidDataException("Dimenesiones mal formadas o fuera de rango.");
        }
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles = vehicles.stream().filter(x -> x.getWeight() >= minW && x.getWeight() <= maxW).toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso.");
        }
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDtos.add(mapper.convertValue(vehicle, VehicleDto.class));
        }
        return vehicleDtos;
    }


}
