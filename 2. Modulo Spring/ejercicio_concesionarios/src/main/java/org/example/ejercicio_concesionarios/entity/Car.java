package org.example.ejercicio_concesionarios.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;
    private List<Service> services;
}
