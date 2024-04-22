package com.spring.concesionaria.services.impl;

import com.spring.concesionaria.dtos.VehicleCreationDTO;
import com.spring.concesionaria.dtos.VehicleResponseDTO;
import com.spring.concesionaria.entities.Vehicle;
import com.spring.concesionaria.exceptions.BadRequestException;
import com.spring.concesionaria.exceptions.InternalServerError;
import com.spring.concesionaria.repositories.IVehicleRepository;
import com.spring.concesionaria.repositories.VehicleRepository;
import com.spring.concesionaria.services.IVehicleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository repository){
        vehicleRepository = repository;
    }

    @Override
    public VehicleCreationDTO addVehicle(VehicleCreationDTO vehicleCreationDTO) {
        Optional<Vehicle> vehicle = vehicleRepository.searchByBrandAndModel(vehicleCreationDTO.getBrand(), vehicleCreationDTO.getModel());
        if(vehicle.isPresent()){
            throw new BadRequestException("Ya existe un vehículo con esas características");
        }
        Vehicle vehicleSaved = vehicleRepository.addVehicle(convertToVehcicle(vehicleCreationDTO));
        if(vehicleSaved == null){
            throw new InternalServerError("Ocurrió un error, vehículo no guardado");
        }
        return convertToVehcicleDTO(vehicleSaved);
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.searchAllVehicles();
        List<VehicleResponseDTO> vehicleResponseList = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            vehicleResponseList.add(convertToVehcicleResponseDTO(vehicle));
        }
        return vehicleResponseList;
    }

    @Override
    public List<VehicleResponseDTO> getSinceDate(LocalDate sinceDate) {
        List<Vehicle> vehicles = vehicleRepository.searchSinceDate(sinceDate);
        List<VehicleResponseDTO> vehicleResponseList = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            vehicleResponseList.add(convertToVehcicleResponseDTO(vehicle));
        }
        return vehicleResponseList;
    }

    @Override
    public List<VehicleResponseDTO> getSincePrice(double sincePrice) {
        List<Vehicle> vehicles = vehicleRepository.searchSincePrice(sincePrice);
        List<VehicleResponseDTO> vehicleResponseList = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            vehicleResponseList.add(convertToVehcicleResponseDTO(vehicle));
        }
        return vehicleResponseList;
    }

    @Override
    public VehicleCreationDTO getById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.searchById(id);
        if(!vehicle.isPresent()){
            throw new BadRequestException("No existe el vehículo con id %id");
        }
        return convertToVehcicleDTO(vehicle.get());
    }

    private Vehicle convertToVehcicle(VehicleCreationDTO vehicleCreationDTO){
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleRepository.searchLastId()+1);
        vehicle.setBrand(vehicleCreationDTO.getBrand());
        vehicle.setModel(vehicleCreationDTO.getModel());
        vehicle.setServices(vehicleCreationDTO.getServices());
        vehicle.setCurrency(vehicleCreationDTO.getCurrency());
        vehicle.setDoors(vehicleCreationDTO.getDoors());
        vehicle.setPrice(vehicleCreationDTO.getPrice());
        vehicle.setCountOfOwners(vehicleCreationDTO.getCountOfOwners());
        vehicle.setManufacturingDate(vehicleCreationDTO.getManufacturingDate());
        vehicle.setNumberOfKilometers(vehicleCreationDTO.getNumberOfKilometers());
        return vehicle;
    }
    private VehicleCreationDTO convertToVehcicleDTO(Vehicle vehicle){
        VehicleCreationDTO vehicleCreationDTO = new VehicleCreationDTO();
        vehicleCreationDTO.setBrand(vehicle.getBrand());
        vehicleCreationDTO.setModel(vehicle.getModel());
        vehicleCreationDTO.setServices(vehicle.getServices());
        vehicleCreationDTO.setCurrency(vehicle.getCurrency());
        vehicleCreationDTO.setDoors(vehicle.getDoors());
        vehicleCreationDTO.setPrice(vehicle.getPrice());
        vehicleCreationDTO.setCountOfOwners(vehicle.getCountOfOwners());
        vehicleCreationDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleCreationDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        return vehicleCreationDTO;
    }

    private VehicleResponseDTO convertToVehcicleResponseDTO(Vehicle vehicle){
        VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();
        vehicleResponseDTO.setBrand(vehicle.getBrand());
        vehicleResponseDTO.setModel(vehicle.getModel());
        vehicleResponseDTO.setCurrency(vehicle.getCurrency());
        vehicleResponseDTO.setDoors(vehicle.getDoors());
        vehicleResponseDTO.setPrice(vehicle.getPrice());
        vehicleResponseDTO.setCountOfOwners(vehicle.getCountOfOwners());
        vehicleResponseDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleResponseDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        return vehicleResponseDTO;
    }
}
