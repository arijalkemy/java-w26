package org.example.prac_exc_p2_car_dealership.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SimpleVehicleDTO implements Serializable {
    private Integer id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;
}
