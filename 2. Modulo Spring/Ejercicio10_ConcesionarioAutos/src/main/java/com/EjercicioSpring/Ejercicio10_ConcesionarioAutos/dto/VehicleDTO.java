package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE) // Ayuda a no tenter que poner el private, por defecto vienen privado
@Builder //No afecta el orden de la entidad (leer más)
@Data
public class VehicleDTO implements Serializable {
    @JsonProperty("brand")
    String brand;

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

    @JsonProperty("services")
    private List<ServiceDTO> servicesDTO;

    @JsonProperty("countOfOwners")
    private int countOfOwners;

    public VehicleDTO(String brand, String model, String manufacturingDate, int numberOfKilometers, int doors, double price, String currency, List<ServiceDTO> servicesDTO, int countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.servicesDTO = servicesDTO;
        this.countOfOwners = countOfOwners;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacturingDate='" + manufacturingDate + '\'' +
                ", numberOfKilometers=" + numberOfKilometers +
                ", doors=" + doors +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                //", servicesDTO=" + servicesDTO +
                ", countOfOwners=" + countOfOwners +
                '}';
    }


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

    public List<ServiceDTO> getServicesDTO() {
        return servicesDTO;
    }

    public void setServicesDTO(List<ServiceDTO> servicesDTO) {
        this.servicesDTO = servicesDTO;
    }

    public int getCountOfOwners() {
        return countOfOwners;
    }

    public void setCountOfOwners(int countOfOwners) {
        this.countOfOwners = countOfOwners;
    }
}
