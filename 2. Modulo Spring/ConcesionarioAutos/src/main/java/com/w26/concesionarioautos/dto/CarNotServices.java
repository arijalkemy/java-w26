package com.w26.concesionarioautos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarNotServices {
    private String brand;
    private String model;
    private LocalDate manufactoringDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private double price;
    private String currency;
    private Integer countOfOwners;
}
