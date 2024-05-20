package org.example.pearl_jewelry.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class JewelDto {
    @NotBlank
    private String name;
    @NotBlank
    private String material;
    @NotNull
    @Positive
    private Integer weight;
    @NotBlank
    private String description;
    @NotNull
    private Boolean hasStone;
    @NotNull
    private Boolean forSale;
}
