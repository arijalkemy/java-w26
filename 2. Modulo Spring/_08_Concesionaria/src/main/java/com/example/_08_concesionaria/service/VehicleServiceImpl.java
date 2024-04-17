package com.example._08_concesionaria.service;

import com.example._08_concesionaria.dto.VehicleDTO;
import com.example._08_concesionaria.dto.VehicleServiceDTO;
import com.example._08_concesionaria.entity.Vehicle;
import com.example._08_concesionaria.entity.VehicleService;
import com.example._08_concesionaria.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService{
    @Autowired
    ICrudRepository<Vehicle> iCrudRepository;
    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) {
        List<Vehicle> vehicles = getAllOriginal();

        //valido si no existe el nombre del vehiculo
        if(vehicles.stream()
                .filter(v->v.getModel().toLowerCase().equals(vehicleDTO.getModel().toLowerCase()))
                .count() == 0){

            iCrudRepository.add(transferToVehicle(vehicleDTO));
            return true;
        }
        return false;
    }

    @Override
    public List<VehicleDTO> getAll() {
        List<VehicleDTO> vehiclesDTOS = new ArrayList<>();

        for (Vehicle vehicle : getAllOriginal()){
            VehicleDTO vehicleDTO = transferToVehicleDTO(vehicle);

            vehiclesDTOS.add(vehicleDTO);
        }

        return vehiclesDTOS;
    }

    @Override
    public List<VehicleDTO> getBetweenDates(Date dateSince, Date dateTo) {
        List<VehicleDTO> vehiclesDTOS = new ArrayList<>();

        //Obtengo el listado de los vehiculos por la condicion de las fechas
        List<Vehicle> vehicles = getAllOriginal().stream()
                .filter(vehicle -> vehicle.getManufacturingDate().after(dateSince)
                        && vehicle.getManufacturingDate().before(dateTo))
                .toList();


        for(Vehicle vehicle : vehicles){
            VehicleDTO vehicleDTO = transferToVehicleDTO(vehicle);

            vehiclesDTOS.add(vehicleDTO);
        }

        return vehiclesDTOS;
    }

    @Override
    public List<VehicleDTO> getBetweenPrices(double priceSince, double priceTo) {
        List<VehicleDTO> vehiclesDTOS = new ArrayList<>();

        //Obtengo el listado de los vehiculos por la condicion de los precios
        List<Vehicle> vehicles = getAllOriginal().stream()
                .filter(vehicle -> vehicle.getPrice() >= priceSince
                        && vehicle.getPrice() <= priceTo)
                .toList();


        for(Vehicle vehicle : vehicles){
            VehicleDTO vehicleDTO = transferToVehicleDTO(vehicle);

            vehiclesDTOS.add(vehicleDTO);
        }

        return vehiclesDTOS;
    }

    @Override
    public VehicleDTO getVehicle(String brand) {
        Vehicle vehicle = getAllOriginal().stream()
                .filter(vehicle1 -> vehicle1.getBrand().toLowerCase().equals(brand.toLowerCase()))
                .findFirst()
                .orElse(null);

        return transferToVehicleDTO(vehicle);
    }

    public List<Vehicle> getAllOriginal(){
        return iCrudRepository.get();
    }

    public Vehicle transferToVehicle(VehicleDTO vehicleDTO){

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setManufacturingDate(vehicleDTO.getManufacturingDate());
        vehicle.setNumberOfKilometers(vehicleDTO.getNumberOfKilometers());
        vehicle.setDoors(vehicleDTO.getDoors());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setCurrency(vehicleDTO.getCurrency());
        vehicle.setCountOfOwners(vehicleDTO.getCountOfOwners());

        vehicle.setServices(transferToVehicleService(vehicleDTO.getServices()));

        return vehicle;
    }

    public VehicleDTO transferToVehicleDTO(Vehicle vehicle){

        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDTO.setDoors(vehicle.getDoors());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setCountOfOwners(vehicle.getCountOfOwners());

        vehicleDTO.setServices(transferToVehicleServiceDTO(vehicle.getServices()));

        return vehicleDTO;
    }

    public List<VehicleService> transferToVehicleService(List<VehicleServiceDTO> serviceDTOS){
        List<VehicleService> services = new ArrayList<>();

        for (VehicleServiceDTO serviceDTO : serviceDTOS)
        {
            VehicleService service = new VehicleService();
            service.setDescription(serviceDTO.getDescription());
            service.setKilometers(serviceDTO.getKilometers());
            service.setDate(serviceDTO.getDate());

            services.add(service);
        }

        return services;
    }

    public List<VehicleServiceDTO> transferToVehicleServiceDTO(List<VehicleService> services){
        List<VehicleServiceDTO> servicesDTO = new ArrayList<>();

        for (VehicleService service : services)
        {
            VehicleServiceDTO serviceDTO = new VehicleServiceDTO();
            serviceDTO.setDescription(service.getDescription());
            serviceDTO.setKilometers(service.getKilometers());
            serviceDTO.setDate(service.getDate());

            servicesDTO.add(serviceDTO);
        }

        return servicesDTO;
    }
}
