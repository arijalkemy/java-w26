package com.example.JoyeriaLasPerlas.dto.jewel;

import lombok.Data;

@Data
public class JewelRequestDto {
    private String name;
    private String material;
    private int weight;
    private String description;
    private Boolean hasStone;
    private Boolean isOnSale;
}
