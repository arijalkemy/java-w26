package com.showroom.showroom.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClothResponseDTO {
    private String name;
    private String type;
    private String brand;
    private String size;
    private String color;
    private int amount;
    private double sellPrice;
}
