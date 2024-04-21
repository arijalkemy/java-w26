package org.example.ejercicio_concesionario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ejercicio_concesionario.models.Service;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarRequestDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
    private List<Service> services;


}
