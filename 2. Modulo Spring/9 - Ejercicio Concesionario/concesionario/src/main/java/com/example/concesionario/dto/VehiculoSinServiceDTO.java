package com.example.concesionario.dto;

import com.example.concesionario.entity.Service;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class VehiculoSinServiceDTO {

    @JsonIgnore
    private int id;
    private String brand;
    private String model;
    private LocalDate manufactoringDate;
    private int numbersOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
}
