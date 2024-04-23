package com.ej2p2dia3spring.carsdealership.service.implementations;

import com.ej2p2dia3spring.carsdealership.dto.VehicleDTO;
import com.ej2p2dia3spring.carsdealership.entity.Vehicle;
import com.ej2p2dia3spring.carsdealership.repository.IVehicleRepository;
import com.ej2p2dia3spring.carsdealership.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Qualifier("vehicleRepositoryImpl")
    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapDTOtoEntity(vehicleDTO);
        vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<VehicleDTO> vehicleDTOs = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.getAllVehicles()) {
            vehicleDTOs.add(mapEntityToDTO(vehicle));
        }
        return vehicleDTOs;
    }

    @Override
    public List<VehicleDTO> getVehiclesByManufacturingDate(String fromDate, String toDate) {
        List<VehicleDTO> vehicleDTOs = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.getAllVehicles()) {
            // Convertir las fechas de fabricación de los vehículos a LocalDate para compararlas
            LocalDate manufacturingDate = LocalDate.parse(vehicle.getManufacturingDate());
            LocalDate from = LocalDate.parse(fromDate);
            LocalDate to = LocalDate.parse(toDate);

            // Verificar si la fecha de fabricación del vehículo está dentro del rango proporcionado
            if (!manufacturingDate.isBefore(from) && !manufacturingDate.isAfter(to)) {
                vehicleDTOs.add(mapEntityToDTO(vehicle));
            }
        }
        return vehicleDTOs;
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(int minPrice, int maxPrice) {
        List<VehicleDTO> vehicleDTOs = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.getAllVehicles()) {
            // Verificar si el precio del vehículo está dentro del rango proporcionado
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                vehicleDTOs.add(mapEntityToDTO(vehicle));
            }
        }
        return vehicleDTOs;
    }

    public VehicleDTO getVehicleById(int id) {
        Vehicle vehicle = vehicleRepository.getVehicleById(id);
        if (vehicle != null) {
            return mapEntityToDTO(vehicle);
        }
        return null;
    }

    private Vehicle mapDTOtoEntity(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDTO.getId());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setManufacturingDate(vehicleDTO.getManufacturingDate());
        vehicle.setNumberOfKilometers(vehicleDTO.getNumberOfKilometers());
        vehicle.setDoors(vehicleDTO.getDoors());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setCurrency(vehicleDTO.getCurrency());
        vehicle.setCountOfOwners(vehicleDTO.getCountOfOwners());

        return vehicle;
    }

    private VehicleDTO mapEntityToDTO(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDTO.setDoors(vehicle.getDoors());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setCountOfOwners(vehicle.getCountOfOwners());

        return vehicleDTO;
    }
}
