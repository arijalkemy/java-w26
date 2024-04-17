package com.practicaSpring.concesionariaDeAutos.dto;

import com.practicaSpring.concesionariaDeAutos.model.Service;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class CarInputDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Integer doors;
    private Long price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;
}
