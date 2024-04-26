package com.bootcampW22.EjercicioGlobal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private String color;
    private int year;
    private String max_speed;
    private int passengers;
    private String fuel_type;
    private String transmission;
    private double height;
    private double width;
    private double weight;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registration='" + registration + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", max_speed='" + max_speed + '\'' +
                ", passengers=" + passengers +
                ", fuel_type='" + fuel_type + '\'' +
                ", transmission='" + transmission + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", weight=" + weight +
                '}';
    }

}
