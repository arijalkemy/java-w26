package org.bootcamp.concesionary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.concesionary.dto.ServiceDTO;
import org.bootcamp.concesionary.dto.VehicleDTO;
import org.bootcamp.concesionary.model.VehService;
import org.bootcamp.concesionary.model.Vehicle;
import org.bootcamp.concesionary.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements IVehicleService {
    @Autowired private VehicleRepository vehicleRepository;

    @Override
    public VehicleDTO getVehicleById(String id) {
    Vehicle vehicle = vehicleRepository.getVehicleById(id);
    return convertToVehicleDTO(vehicle);
    }

    @Override
    public String addVehicle(VehicleDTO vehicleDTO) {
        Vehicle v = convertToVehicle(vehicleDTO);
        vehicleRepository.addVehicle(v);
        return "Vehicle added successfully";
    }

    @Override
    public List<VehicleDTO> getVehiclesBetweenDates(Date since, Date to) {
        return vehicleRepository.getVehiclesBetweenDates(since, to).stream().map(this::convertToVehicleDTO).toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesBetweenPrices(Integer since, Integer to) {
        return vehicleRepository.getVehiclesBetweenPrices(since, to).stream().map(this::convertToVehicleDTO).toList();
    }


    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.getAllVehicles().stream().map(this::convertToVehicleDTO).toList();
    }

    private VehicleDTO convertToVehicleDTO(Vehicle vehicle) {
        List<VehService> services = vehicle.getServices();
        return new VehicleDTO(
            vehicle.getBrand(),
            vehicle.getModel(),
            vehicle.getManufacturingDate(),
            vehicle.getNumberOfKilometers(),
            vehicle.getDoors(),
            vehicle.getPrice(),
            vehicle.getCurrency(),
            vehicle.getCountOfOwners(),
            services.stream().map(service -> new ServiceDTO(service.getDate(), service.getKilometers(), service.getDescriptions())).toList()
        );
    }

    private Vehicle convertToVehicle(VehicleDTO vehicleDTO) {
        List<ServiceDTO> servicesDTO = vehicleDTO.getServices();
        return new Vehicle(
            UUID.randomUUID().toString(),
            vehicleDTO.getBrand(),
            vehicleDTO.getModel(),
            vehicleDTO.getManufacturingDate(),
            vehicleDTO.getNumberOfKilometers(),
            vehicleDTO.getDoors(),
            vehicleDTO.getPrice(),
            vehicleDTO.getCurrency(),
            servicesDTO.stream().map(serviceDTO -> new VehService(serviceDTO.getDate(), serviceDTO.getKilometers(), serviceDTO.getDescriptions())).toList(),
            vehicleDTO.getCountOfOwners()
        );
    }
}
