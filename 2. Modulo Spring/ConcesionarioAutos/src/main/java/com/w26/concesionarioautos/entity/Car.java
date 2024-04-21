package com.w26.concesionarioautos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufactoringDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private double price;
    private String currency;
    private Integer countOfOwners;

    private static Integer ids = 0;

    public static Integer generateId()
    {
        Integer toReturnId = ids;
        ids = ids + 1;
        return toReturnId;
    }

    public Car(String brand, String model, LocalDate manufactoringDate, Integer numberOfKilometers, Integer doors, double price, String currency, Integer countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufactoringDate = manufactoringDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;

        this.id = generateId();
    }
}
