package com.bootcampW22.EjercicioGlobal.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestVehicleDTO {
    @NotBlank(message = "El auto debe tener una marca")
    private String brand;
    @NotBlank(message = "El auto debe tener una marca")
    private String model;
    @NotBlank(message = "El auto debe tener una matricula")
    private String registration;
    private String color;
    @Max(value = 2024, message = "El auto no puede ser modelo mayor al año actual")
    private int year;
    @Positive(message = "El auto debe tener una velocidad mayor a 0")
    private Integer max_speed;
    @Positive(message = "El auto debe tener una velocidad mayor a 0")
    private int passengers;
    @NotBlank(message = "El auto debe tener una matricula")
    private String fuel_type;
    @NotBlank(message = "El auto debe tener una matricula")
    private String transmission;
    @Positive(message = "El peso del vehiculo debe ser positivo")
    private double height;
    @Positive(message = "El peso del vehiculo debe ser positivo")
    private double width;
    @Positive(message = "El peso del vehiculo debe ser positivo")
    private double weight;
}
