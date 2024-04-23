package org.bootcamp.concesionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleDTO {
    private String id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private String countOfOwners;
    private List<ServiceDTO> services;
}
