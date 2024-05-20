package com.bootcamp.joyeria.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelResponseDTO {
    private Long id;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private boolean hasStone;
    private boolean sellOrNot;
}
