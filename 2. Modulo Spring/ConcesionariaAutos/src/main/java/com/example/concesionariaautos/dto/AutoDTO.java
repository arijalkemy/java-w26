package com.example.concesionariaautos.dto;

import com.example.concesionariaautos.model.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoDTO {
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKm;
    private Integer doors;
    private Integer price;
    private String currency;
    private Integer countOfOwners;

    public static Integer contador = 0;



}
