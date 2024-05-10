package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    public ExceptionDto addNewVehicle(Vehicle v) {

        if (vehicleRepository.findVehicleById(v.getId()).isPresent()) {
            throw new ConflictException("Identificador del vehículo ya existente.");
        }
        vehicleRepository.addVehicle(v);

        ExceptionDto response = new ExceptionDto("Vehiculo creado correctamente");
        return response;
    }

    @Override
    public List<VehicleDto> findVehicleByColorAndYear(String color, int year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesFound = vehicleRepository.findVehicleByColorAndYear(color, year);
        if (vehiclesFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return vehiclesFound.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findVehiclesByBrandAndRangeOfYears(String brand, int start_year, int end_year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesFound = vehicleRepository.findVehiclesByBrandAndRangeOfYears(brand, start_year, end_year);
        if (vehiclesFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return vehiclesFound.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    @Override
    public AvgSpeedDTO calculateSpeedAvgByBrand(String brand) {
        List<Vehicle> foundedVehicles = vehicleRepository.findVehiclesByBrand(brand);
        if (foundedVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        double avgSpeed = foundedVehicles.stream().mapToInt(v -> Integer.parseInt(v.getMax_speed())).average().orElse(0);
        AvgSpeedDTO AvgDto = new AvgSpeedDTO();
        AvgDto.setAvgSpeed(String.valueOf(avgSpeed));


        return AvgDto;
    }

    @Override
    public ExceptionDto addVehicles(List<Vehicle> listVehicles) {

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesWithSameId = new ArrayList<>();
        listVehicles.stream().forEach(v -> {
            Optional<Vehicle> ov = vehicleRepository.findVehicleById(v.getId());
            if (ov.isPresent()) {
                vehiclesWithSameId.add(ov.get());
            }

        });
        if (vehiclesWithSameId.size() > 0) {
            throw new ConflictException("Algún vehículo tiene un identificador ya existente.");
        }
        List<Vehicle> newVehiclesList = vehicleRepository.addVehicles(listVehicles);

        newVehiclesList.stream().map(v -> mapper.convertValue(v, VehicleDto.class));

        ExceptionDto e = new ExceptionDto("Vehículos creados exitosamente.");

        return e;
    }

    @Override
    public ExceptionDto updateMaxSpeed(Long id, MaxSpeedDto maxSpeed) {
        Optional<Vehicle> ov = vehicleRepository.findVehicleById(id);
        if (ov.isPresent()) {
            ov.get().setMax_speed(maxSpeed.getMax_speed());
            vehicleRepository.updateVehicle(ov.get());
        } else {
            throw new NotFoundException("No se encontró el vehículo.");
        }
        return new ExceptionDto("Velocidad del vehículo actualizada exitosamente");
    }

    @Override
    public List<VehicleDto> findVehiclesByFuelType(String fuel_type) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesByFuelType = vehicleRepository.findVehicleByFuelType(fuel_type);
        if (vehiclesByFuelType.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return vehiclesByFuelType.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    @Override
    public ExceptionDto deleteVehicle(Long id) {
        Optional<Vehicle> vehicleFound = vehicleRepository.findVehicleById(id);
        if (vehicleFound.isEmpty()) {
            throw new NotFoundException("No se encontró el vehículo.");
        }
        vehicleRepository.deleteVehicle(vehicleFound.get());
        ExceptionDto eDto = new ExceptionDto("Vehículo eliminado exitosamente.");
        return eDto;
    }

    @Override
    public List<VehicleDto> findVehiclesByTransmission(String transmission) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vFound = vehicleRepository.findVehiclesByTransmission(transmission);
        if (vFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos con ese tipo de transmisión");
        }
        return vFound.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    @Override
    public ExceptionDto updateFuelType(Long id, FuelTypeDto fuelType) {
        Optional<Vehicle> vFound = vehicleRepository.findVehicleById(id);
        if (vFound.isPresent()) {
            vFound.get().setFuel_type(fuelType.getFuel_type());
            vehicleRepository.updateVehicle(vFound.get());
        } else {
            throw new NotFoundException("No se encontró el vehículo.");
        }
        ExceptionDto eDto = new ExceptionDto();
        eDto.setMessage("Tipo de combustible del vehículo actualizado exitosamente.");

        return eDto;
    }

    @Override
    public AvgCapacityDto calculateAvgCapacityByBrand(String brand) {
        List<Vehicle> vFound = vehicleRepository.findVehiclesByBrand(brand);
        if (vFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos con esa marca");
        }
        AvgCapacityDto aDto = new AvgCapacityDto();
        aDto.setAvg_capacity(vFound.stream().mapToDouble(v -> v.getPassengers()).average().orElse(0));
        return aDto;
    }

    @Override
    public List<VehicleDto> findVehiclesByDimenssions(String length, String width) {
        ObjectMapper mapper = new ObjectMapper();
        String[] lengthRange = length.split("-");
        String[] widthRange = width.split("-");
        List<Vehicle> vFound = vehicleRepository.findVehiclesByDimenssions(Double.parseDouble(lengthRange[0]),
                Double.parseDouble(lengthRange[1]),
                Double.parseDouble(widthRange[0]),
                Double.parseDouble(widthRange[1]));
        if (vFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }
        return vFound.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findVehiclesByWeightRange(double min, double max) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vFound = vehicleRepository.findVehiclesByWeightRange(min, max);
        if (vFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos con esas dimensiones");
        }
        return vFound.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }
}
