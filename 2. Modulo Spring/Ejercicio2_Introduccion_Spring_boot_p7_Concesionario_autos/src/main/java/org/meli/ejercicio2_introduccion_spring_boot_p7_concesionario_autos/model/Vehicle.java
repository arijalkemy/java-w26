package org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @JsonIgnore
    private Long id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberofKilometers;
    private Integer doors;
    private Integer price;
    private String  currenoy;
    private List<ServiceVehicle> list;
    private Integer countOfOwners;
}
