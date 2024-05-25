package com.example.demo.model.dto.clothesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClothesRequestDTO {
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer amount;
    private Double salePrice;
}
