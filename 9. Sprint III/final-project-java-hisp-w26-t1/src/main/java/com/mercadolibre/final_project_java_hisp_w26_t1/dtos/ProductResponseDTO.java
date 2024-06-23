package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

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
