package com.spring.concesionaria.service;

import com.spring.concesionaria.dto.VServiceDTO;
import com.spring.concesionaria.dto.VehicleDTO;
import com.spring.concesionaria.entity.VService;
import com.spring.concesionaria.entity.Vehicle;
import com.spring.concesionaria.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiclesService implements IVehiclesService {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    @Override
    public VehicleDTO findById(Integer id) {
        Vehicle foundVehicle = this.vehiclesRepository.search(id);
        if (foundVehicle != null) {
            return this.parseVehicleToDTO(foundVehicle);
        }
        return null;
    }

    @Override
    public List<VehicleDTO> findBetweenDates(String since, String to) {
        try {
            LocalDate sinceDate = LocalDate.parse(since);
            LocalDate toDate = LocalDate.parse(to);

            return this.vehiclesRepository.getAll()
                    .stream()
                    .filter(vehicle -> {
                        LocalDate date = vehicle.getManufacturingDate();
                        return toDate.isAfter(date) && sinceDate.isBefore(date);
                    })
                    .map(this::parseVehicleToDTO)
                    .toList();

        } catch (DateTimeParseException e) {
            System.out.println("Error en el parseo de dates: " + e.getMessage());
        }
        return List.of();
    }

    @Override
    public List<VehicleDTO> findBetweenPrices(String since, String to) {
        try {
            return this.vehiclesRepository.getAll()
                    .stream()
                    .filter(vehicle ->
                            vehicle.getPrice() >= Double.parseDouble(since) &&
                                    vehicle.getPrice() <= Double.parseDouble(to))
                    .map(this::parseVehicleToDTO)
                    .toList();
        } catch (NumberFormatException e) {
            System.out.println("Error en el parseo de datos: " + e.getMessage());
        }
        return List.of();

    }

    @Override
    public List<VehicleDTO> findAll() {
        List<VehicleDTO> vehiclesDTO = new ArrayList<>();
        for (Vehicle vehicle : this.vehiclesRepository.getAll()) {
            vehiclesDTO.add(this.parseVehicleToDTO(vehicle));
        }
        return vehiclesDTO;
    }

    @Override
    public void create(VehicleDTO vehicle) {
        this.vehiclesRepository.create(this.parseVehicleFromDTO(vehicle));
    }

    private List<VServiceDTO> parseServicesToDTO(List<VService> services) {
        List<VServiceDTO> serviceDTOs = new ArrayList<>();
        for (VService service : services) {
            serviceDTOs.add(new VServiceDTO(
                    service.getDate().toString(),
                    service.getKilometers(),
                    service.getDescriptions()
            ));
        }
        return serviceDTOs;
    }

    private List<VService> parseServicesFromDTO(List<VServiceDTO> servicesDTO) {
        List<VService> services = new ArrayList<>();
        for (VServiceDTO service : servicesDTO) {
            services.add(new VService(
                    LocalDate.parse(service.getDate()),
                    service.getKilometers(),
                    service.getDescriptions()
            ));
        }
        return services;
    }

    private Vehicle parseVehicleFromDTO(VehicleDTO vehicleDTO) {
        LocalDate manufacturingDate = LocalDate.parse(vehicleDTO.getManufacturingDate());
        List<VService> services = this.parseServicesFromDTO(vehicleDTO.getServices());

        return new Vehicle(
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                manufacturingDate,
                vehicleDTO.getNumberOfKilometers(),
                vehicleDTO.getDoors(),
                vehicleDTO.getPrice(),
                vehicleDTO.getCurrency(),
                services
        );
    }

    private VehicleDTO parseVehicleToDTO(Vehicle vehicle) {
        List<VServiceDTO> servicesDTO = this.parseServicesToDTO(vehicle.getServices());

        return new VehicleDTO(
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate().toString(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                servicesDTO
        );
    }
}
