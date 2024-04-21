package com.w26.concesionarioautos.dto;

import com.w26.concesionarioautos.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarServices {
    private String brand;
    private String model;
    private LocalDate manufactoringDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private double price;
    private String currency;
    private Integer countOfOwners;
    private List<Service> serviceList;
}
