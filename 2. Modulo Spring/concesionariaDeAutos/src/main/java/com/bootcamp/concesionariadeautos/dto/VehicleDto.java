package com.bootcamp.concesionariadeautos.dto;

import com.bootcamp.concesionariadeautos.entity.Service;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class VehicleDto implements Serializable {

    private String brand;
    private String model;
    private Date manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
    private List<Service> services;
}
