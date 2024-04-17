package co.com.mercadolibre.autos.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Vehicle {
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;
}
