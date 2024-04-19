package org.example.concesionaria.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class VehicleCompleteDTO {
    UUID id;
    String brand;
    String model;
    LocalDate manufacturingDate;
    String numberOfKilometers;
    String doors;
    String price;
    String currency;
    List<ServiceDTO> services;
    String countOfOwners;
}
