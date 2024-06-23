package com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductResponseDTO {
    private String name;
    private Double price;
    private String category;
}
