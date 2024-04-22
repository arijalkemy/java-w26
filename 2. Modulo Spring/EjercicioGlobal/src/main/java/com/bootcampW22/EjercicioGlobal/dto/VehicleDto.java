package com.bootcampW22.EjercicioGlobal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    @NonNull
    private Long id;
    @NonNull
    private String brand;
    @NonNull
    private String model;
    @NonNull
    private String registration;
    @NonNull
    private String color;
    @NonNull
    private int year;
    @NonNull
    private String max_speed;
    @NonNull
    private int passengers;
    @NonNull
    private String fuel_type;
    @NonNull
    private String transmission;
    @NonNull
    private double height;
    @NonNull
    private double width;
    @NonNull
    private double weight;
}
