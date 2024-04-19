package org.example._09concesionaria.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._09concesionaria.DTO.AddVehicleRequestDTO;
import org.example._09concesionaria.DTO.ServiceDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;

    public Vehicle(AddVehicleRequestDTO vehicleRequestDTO) {
        this.brand = vehicleRequestDTO.getBrand();
        this.model = vehicleRequestDTO.getModel();
        this.manufacturingDate = vehicleRequestDTO.getManufacturingDate();
        this.numberOfKilometers = vehicleRequestDTO.getNumberOfKilometers();
        this.doors = vehicleRequestDTO.getDoors();
        this.price = vehicleRequestDTO.getPrice();
        this.currency = vehicleRequestDTO.getCurrency();
        this.services = new ArrayList<>();
        for (ServiceDTO serviceDTO : vehicleRequestDTO.getServices()) {
            this.services.add(
                    new Service(serviceDTO.getDate(), serviceDTO.getKilometers(), serviceDTO.getDescriptions())
            );
        }
        this.countOfOwners = vehicleRequestDTO.getCountOfOwners();
    }
}
