package com.example.joyerialasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelryDto {

    private String name;
    private String material;
    private double weight;
    private String description;
    @JsonProperty("has_gem")
    private boolean hasGem;
    @JsonProperty("sale_or_not")
    private boolean saleOrNot;


}
