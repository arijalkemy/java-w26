package com.example.showroom_vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothesDTO {
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private Double size;
    private Integer amount;
    private Double price;
}
