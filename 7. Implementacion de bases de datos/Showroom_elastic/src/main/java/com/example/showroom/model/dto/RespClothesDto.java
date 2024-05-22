package com.example.showroom.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespClothesDto {
    private String id;
    private String description;
    private String color;
    private String size;
    private String material;
    private String brand;
    private double price;
    private String type;
}
