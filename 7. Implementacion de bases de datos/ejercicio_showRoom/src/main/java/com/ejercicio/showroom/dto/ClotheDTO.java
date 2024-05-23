package com.ejercicio.showroom.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClotheDTO {
    private String name;
    private String type;
    private String brand;
    private String colour;
    private String waist;
    private int quantity;
    private double price;
}
