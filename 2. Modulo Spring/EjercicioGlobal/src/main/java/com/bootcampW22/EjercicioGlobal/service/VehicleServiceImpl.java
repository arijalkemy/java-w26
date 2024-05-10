package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

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

    // Ejercicio 1
    @Override
    public VehicleDto postNewVehicles(VehicleDto vehicleDto) {
        Long id = vehicleDto.getId();
        Optional<Vehicle> val = this.vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst();
        if (val.isPresent()) {
            throw new IllegalArgumentException("Valor ya existente");
        }
        vehicleRepository.saveVehicle(vehicleDto);
        return vehicleDto;
    }

    // Ejercicio 2
    @Override
    public List<VehicleDto> getVehiclesByColorAndYear(String color, int year) {
        List<Vehicle> vehicles = this.vehicleRepository.searchByColorAndYear(color, year);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("no hay datos");
        }
        return vehicles.stream()
                .map(v -> objectMapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    // Ejercicio 3
    @Override
    public List<VehicleDto> getVehiclesByBrandAndYearRange(String brand, int start_year, int end_year) {
        List<Vehicle> vehicles = this.vehicleRepository.searchByBrandAndYearRange(brand, start_year, end_year);
        return vehicles.stream().map(v -> objectMapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    // Ejercicio 4
    @Override
    public int getAvgSpeedByBrand(String brand) {
        return this.vehicleRepository.getAvgSpeedByBrand(brand);
    }

    // Ejercicio 5
    @Override
    public List<VehicleDto> postVehicleBatch(List<VehicleDto> vehicleDto) {
        this.vehicleRepository.saveVehicleBatch(vehicleDto);
        return vehicleDto;
    }

    // Ejercicio 6
    @Override
    public VehicleDto changeSpeedById(Long id, String max_speed) {
        Optional<Vehicle> vehicle = this.vehicleRepository.findById(id);
        if (vehicle.isEmpty()) {
            throw new NotFoundException("No se ubico el registro a modificar");
        }
        vehicle.get().setMax_speed(max_speed);
        VehicleDto vehicleDto = new VehicleDto(vehicle.get().getId(), vehicle.get().getBrand(),
                vehicle.get().getModel(), vehicle.get().getRegistration(),
                vehicle.get().getColor(), vehicle.get().getYear(), vehicle.get().getMax_speed(),
                vehicle.get().getPassengers(), vehicle.get().getFuel_type(),
                vehicle.get().getTransmission(), vehicle.get().getHeight(),
                vehicle.get().getWidth(), vehicle.get().getWeight());

        return vehicleDto;
    }

    // Ejercicio 7
    @Override
    public List<VehicleDto> getVehiclesByFuel(String type) {
        List<Vehicle> vehicles = this.vehicleRepository.searchByFuel(type);
        return vehicles.stream().map(v -> objectMapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    // Ejercicio 8
    @Override
    public String deleteById(Long id) {
        this.vehicleRepository.deleteById(id);
        return "el registro ha sido eliminado";
    }

    // Ejercicio 9
    @Override
    public List<VehicleDto> getByTransmission(String type) {
        List<Vehicle> vehicles = this.vehicleRepository.searchByTransmission(type);
        return vehicles.stream().map(vehicle -> objectMapper.convertValue(vehicle, VehicleDto.class)).collect(Collectors.toList());
    }

    // Ejercicio 10
    @Override
    public VehicleDto changeFuelType(Long id, String fuel_type) {
        Optional<Vehicle> vehicle = this.vehicleRepository.findById(id);
        if (vehicle.isEmpty()) {
            throw new NotFoundException("No se encuentra el registro");
        }
        vehicle.get().setFuel_type(fuel_type);
        VehicleDto vehicleDto = new VehicleDto(vehicle.get().getId(), vehicle.get().getBrand(),
                vehicle.get().getModel(), vehicle.get().getRegistration(),
                vehicle.get().getColor(), vehicle.get().getYear(), vehicle.get().getMax_speed(),
                vehicle.get().getPassengers(), vehicle.get().getFuel_type(),
                vehicle.get().getTransmission(), vehicle.get().getHeight(),
                vehicle.get().getWidth(), vehicle.get().getWeight());

        return vehicleDto;
    }

    // Ejercicio 11
    @Override
    public Double getAvgByBrand(String brand) {
        return this.vehicleRepository.getAvgByBrand(brand);
    }

    // Ejercicio 12
    @Override
    public List<VehicleDto> getDimensions(String length, String width) {
        List<Vehicle> vehicles = this.vehicleRepository.searchByDimensions(length, width);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encuentran vehiculos con esas medidas");
        }
        return vehicles.stream().map(v -> objectMapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }

    // Ejercicio 13
    @Override
    public List<VehicleDto> getVehiclesByWeightRange(double min, double max) {
        List<Vehicle> vehicles = this.vehicleRepository.searchByWeightRange(min, max);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encuentran datos con este rango");
        }
        return vehicles.stream().map(v -> objectMapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());
    }
}
