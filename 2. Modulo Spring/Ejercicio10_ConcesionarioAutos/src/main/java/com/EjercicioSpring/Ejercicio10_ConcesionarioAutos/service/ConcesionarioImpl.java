package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.service;

import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto.ServiceDTO;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto.VehicleDTO;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto.VehicleWhitoutServiceDTO;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Vehicle;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.repository.ServiceRepository;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.repository.VehicleRepository;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.service.interfaces.IConcesionarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ConcesionarioImpl implements IConcesionarioService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ServiceRepository serviceRepository;

    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {
        List<com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Service> services = new ArrayList<>();
        LocalDate date = LocalDate.parse(vehicleDTO.getManufacturingDate());
        Vehicle vehicle = new Vehicle(
                vehicleDTO.getBrand(), vehicleDTO.getModel(), date, vehicleDTO.getNumberOfKilometers(),
                vehicleDTO.getDoors(), vehicleDTO.getPrice(), vehicleDTO.getCurrency(), vehicleDTO.getCountOfOwners()
        );
        vehicle = vehicleRepository.addElement(vehicle);
        if (!vehicleDTO.getServicesDTO().isEmpty()) {
            for (ServiceDTO serviceDTO : vehicleDTO.getServicesDTO()) {
                LocalDate dateService = LocalDate.parse(serviceDTO.getDate());
                com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Service service =
                        new com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Service(
                                vehicle.getId(), dateService, serviceDTO.getKilometers(), serviceDTO.getDescription()
                        );
                serviceRepository.addElement(service);
            }
        } else {
            System.out.println("Lista vacía");
        }
    }

    @Override
    public List<VehicleWhitoutServiceDTO> getVehicles() {
        List<VehicleWhitoutServiceDTO> vehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.getAll().values()) {
            vehicles.add(new VehicleWhitoutServiceDTO(
                    vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate().toString(),
                    vehicle.getNumberOfKilometers(), vehicle.getDoors(),vehicle.getPrice(), vehicle.getCurrency(),
                    vehicle.getCountOfOwners())
            );
        }
        return vehicles;
        //return new ArrayList<>(vehicleRepository.getAll().values()).stream().map(v -> objectMapper.convertValue(v,VehicleWhitoutServiceDTO.class)).toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesByDate(LocalDate since, LocalDate to) {
        List<Vehicle> vehicles = new ArrayList<>(vehicleRepository.getAll().values());
        List<VehicleDTO> vehiclesDTO = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getManufacturingDate().isAfter(since) && vehicle.getManufacturingDate().isBefore(to)) {
                List<ServiceDTO> services = new ArrayList<>();
                for (com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Service service 
                        : serviceRepository.getAllByForeingId(vehicle.getId())) {
                    services.add(
                            new ServiceDTO(service.getDate().toString(), service.getKilometers(), 
                                    service.getDescription())
                    );
                }
                vehiclesDTO.add(new VehicleDTO(vehicle.getBrand(), vehicle.getModel(),
                        vehicle.getManufacturingDate().toString(), vehicle.getNumberOfKilometers(), vehicle.getDoors(),
                        vehicle.getPrice(), vehicle.getCurrency(), services, vehicle.getCountOfOwners())
                );
            }
        }
        return vehiclesDTO;
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(double since, double to) {
        List<Vehicle> vehicles = new ArrayList<>(vehicleRepository.getAll().values());
        List<VehicleDTO> vehiclesDTO = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() >= since && vehicle.getPrice() <= to) {
                List<ServiceDTO> services = new ArrayList<>();
                for (com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Service service
                        : serviceRepository.getAllByForeingId(vehicle.getId())) {
                    services.add(new ServiceDTO(service.getDate().toString(), service.getKilometers(),
                                    service.getDescription())
                    );
                }
                vehiclesDTO.add(new VehicleDTO(vehicle.getBrand(), vehicle.getModel(),
                        vehicle.getManufacturingDate().toString(), vehicle.getNumberOfKilometers(),
                        vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), services,
                        vehicle.getCountOfOwners())
                );
            }
        }
        return vehiclesDTO;
    }

    @Override
    public VehicleDTO getVehicleById(Integer id) {
        Vehicle vehicle = vehicleRepository.getById(id);
        if (vehicle == null) {
            return null;
        }
        List<ServiceDTO> services = new ArrayList<>();
        for (com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Service service
                : serviceRepository.getAllByForeingId(vehicle.getId())) {
            services.add(new ServiceDTO(service.getDate().toString(), service.getKilometers(),
                            service.getDescription())
            );
        }
        return new VehicleDTO(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate().toString(),
                vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(),
                services, vehicle.getCountOfOwners()
        );
    }
}
