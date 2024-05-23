package com.example.showroom.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClothRequestDTO {
    private String name;
    private String type;
    private String brand;
    private String color;
    private Integer size;
    private int quantity;
    private double salePrice;
}
