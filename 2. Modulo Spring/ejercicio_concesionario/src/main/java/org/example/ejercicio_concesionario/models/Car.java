package org.example.ejercicio_concesionario.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {
    private Long id;
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
    private List<Service> services;
}
