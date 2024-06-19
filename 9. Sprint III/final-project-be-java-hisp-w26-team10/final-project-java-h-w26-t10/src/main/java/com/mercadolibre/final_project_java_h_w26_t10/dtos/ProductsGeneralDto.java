package com.mercadolibre.final_project_java_h_w26_t10.dtos;

import com.mercadolibre.final_project_java_h_w26_t10.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsGeneralDto {
    private String name;
    private Double price;
}
