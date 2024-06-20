package com.example.seguros.dto;

import com.example.seguros.model.Sinister;
import lombok.Builder;

import java.util.List;

@Builder
public class VehicleDTO {

    private Long id;
    private String patent;
    private String brand;
    private String model;
    private int yearProduction;
    private int numberWheels;
    private List<Sinister> sinisters;
}
