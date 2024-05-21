package com.example.productoselastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductResponseDto {
    private String id;
    private String name;
    private String type;
    private Double pCosto;
    private Double pVenta;
    private int stock;
}
