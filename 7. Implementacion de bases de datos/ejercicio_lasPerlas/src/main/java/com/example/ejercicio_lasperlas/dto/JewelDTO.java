package com.example.ejercicio_lasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelDTO {
    private long id;
    private String name;
    private String material;
    private double weight;
    private String particularity;
    private boolean hasStone;
    private boolean isForSale;
}
