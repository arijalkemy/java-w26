package org.example._09concesionaria.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example._09concesionaria.Model.Service;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetCompleteVehicleResponseDTO implements Serializable {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;
}
