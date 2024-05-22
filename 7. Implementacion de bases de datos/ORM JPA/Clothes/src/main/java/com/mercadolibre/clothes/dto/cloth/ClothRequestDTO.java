package com.mercadolibre.clothes.dto.cloth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ClothRequestDTO implements Serializable {
    private String name;
    private String type;
    private String brand;
    private String color;
    private Integer size;
    private Integer quantity;
    private Double price;
}
