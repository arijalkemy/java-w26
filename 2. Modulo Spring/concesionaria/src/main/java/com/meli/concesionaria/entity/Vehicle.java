package com.meli.concesionaria.entity;

import java.util.List;

public class Vehicle {
    private static int nextId = 1;
   private Integer id;
   private String brand;
   private String model;
   private String manufacturingDate;
   private  Integer numberOfKilometers;
   private  Integer doors;
   private  Integer price;
   private  String currency;
   private List<Service> services;


    public Vehicle(String brand, String model, String manufacturingDate, Integer numberOfKilometers, Integer doors, Integer price, String currency, List<Service> services) {
        this.id = nextId;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        nextId++;

    }

    public Vehicle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

     public Integer getNumberOfKilometers() {
          return numberOfKilometers;
     }

     public void setNumberOfKilometers(Integer numberOfKilometers) {
          this.numberOfKilometers = numberOfKilometers;
     }

     public Integer getDoors() {
          return doors;
     }

     public void setDoors(Integer doors) {
          this.doors = doors;
     }

     public Integer getPrice() {
          return price;
     }

     public void setPrice(Integer price) {
          this.price = price;
     }

     public String getCurrency() {
          return currency;
     }

     public void setCurrency(String currency) {
          this.currency = currency;
     }

     public List<Service> getServices() {
          return services;
     }

     public void setServices(List<Service> services) {
          this.services = services;
     }



    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacturingDate='" + manufacturingDate + '\'' +
                ", numberOfKilometers=" + numberOfKilometers +
                ", doors=" + doors +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", services=" + services +
                '}';
    }
}
