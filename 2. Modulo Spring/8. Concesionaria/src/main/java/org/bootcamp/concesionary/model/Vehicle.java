package org.bootcamp.concesionary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Vehicle {
    private String id;
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private Integer numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private List<VehService> services;
    private String countOfOwners;
}
