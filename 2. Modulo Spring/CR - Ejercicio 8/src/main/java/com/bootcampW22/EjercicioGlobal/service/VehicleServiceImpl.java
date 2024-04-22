package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

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
    public String createVehicle(Vehicle vehicle) {
        boolean created = vehicleRepository.add( vehicle );

        if( created ){
            return "Vehículo creado exitosamente.";
        } else {
            throw new ConflictException("Identificador del vehículo ya existente.");
        }
    }

    @Override
    public double avgCapacityPerBrand(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        if( vehicles.isEmpty() ){
            throw new NotFoundException("No hay vehiculos diponibles.");
        }
        List<Vehicle> vehiclePerBrand = vehicles.stream().filter( v -> v.getBrand().equalsIgnoreCase( brand ) ).toList();
        if( vehiclePerBrand.isEmpty() ){
            throw new NotFoundException("No hay vehiculos de la marca: " + brand);
        }
        return vehiclePerBrand.stream().mapToInt( Vehicle::getPassengers ).average().getAsDouble();
    }

    @Override
    public List<VehicleDto> searchByBrandAndYear(String brand, int startYear, int endYear) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        if( vehicles.isEmpty() ){
            throw new NotFoundException("No hay vehiculos diponibles.");
        }
        List<Vehicle> vehiclesByBrandAndYear = vehicles.stream().filter( v -> v.getBrand().equals(brand) && v.getYear() >= startYear && v.getYear() <= v.getYear()).toList();
        if( vehiclesByBrandAndYear.isEmpty() ){
            throw new NotFoundException("No hay vehiculos de la marca: " + brand + " para los anios: " + startYear + " - " + endYear );
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehiclesByBrandAndYear.stream().map( v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public String updateMaxSpedVehicle(Long id, Vehicle vehicle) {
        if( id != vehicle.getId() ){
            throw new BadRequestException("El id del vehiculo no es valido.");
        }

        String maxSpeed =  vehicle.getMax_speed();
        if( maxSpeed.isEmpty() || maxSpeed.equals("0") || Double.valueOf(maxSpeed) > 300.00 ){
            throw new BadRequestException("Velocidad mal formada o fuera de rango.");
        }


        boolean updated = vehicleRepository.updateMaxSpeed( id, vehicle );

        if( !updated ) {
            throw new NotFoundException("No se econtro el vehiculo.");
        }
        return "Velocidad del vehiclo actualizada exitosamente.";
    }
}
