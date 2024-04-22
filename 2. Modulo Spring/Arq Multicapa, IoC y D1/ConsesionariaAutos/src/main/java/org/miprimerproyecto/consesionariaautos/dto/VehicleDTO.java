package org.miprimerproyecto.consesionariaautos.dto;

import lombok.Data;
import org.miprimerproyecto.consesionariaautos.model.Services;

import java.io.Serializable;
import java.util.List;
@Data
public class VehicleDTO implements Serializable {
    String brand;
    String model;
    String manufacturingDate;
    int numerOfKilometers;
    int doors;
    int price;
    String currency;
    List<Services> listServices;
    int countOfOwners;

    public VehicleDTO(String brand, String model, String manufacturingDate, int numerOfKilometers, int doors,
                      int price, String currency, List<Services> listServices, int countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numerOfKilometers = numerOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.listServices = listServices;
        this.countOfOwners = countOfOwners;
    }
}
