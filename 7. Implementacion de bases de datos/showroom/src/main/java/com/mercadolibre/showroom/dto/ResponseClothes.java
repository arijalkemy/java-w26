package com.mercadolibre.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClothes {
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private int quantity;
    private double price;
}
