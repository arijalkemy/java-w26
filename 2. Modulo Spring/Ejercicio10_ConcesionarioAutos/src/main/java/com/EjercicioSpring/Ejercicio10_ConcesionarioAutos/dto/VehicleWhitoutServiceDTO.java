package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE) // Ayuda a no tenter que poner el private, por defecto vienen privado
@Builder //No afecta el orden de la entidad (leer más)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleWhitoutServiceDTO implements Serializable {
    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("manufacturingDate")
    private String manufacturingDate;

    @JsonProperty("numberOfKilometers")
    private int numberOfKilometers;

    @JsonProperty("doors")
    private int doors;

    @JsonProperty("price")
    private double price;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("countOfOwners")
    private int countOfOwners;

    /*public VehicleWhitoutServiceDTO(String brand, String model, String manufacturingDate, int numberOfKilometers, int doors, double price, String currency, int countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }*/

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(int numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCountOfOwners() {
        return countOfOwners;
    }

    public void setCountOfOwners(int countOfOwners) {
        this.countOfOwners = countOfOwners;
    }
}
