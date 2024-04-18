package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity;

import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto.ServiceDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Vehicle {
    @Id
    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;

    public Vehicle(Integer id, String brand, String model, LocalDate manufacturingDate, int numberOfKilometers, int doors, double price, String currency, int countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }

    public Vehicle(String brand, String model, LocalDate manufacturingDate, int numberOfKilometers, int doors, double price, String currency, int countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }

    public Vehicle() {

    }
}
