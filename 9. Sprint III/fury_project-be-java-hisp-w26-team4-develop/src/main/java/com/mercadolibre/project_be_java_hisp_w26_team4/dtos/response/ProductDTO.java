package com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response;

import com.mercadolibre.project_be_java_hisp_w26_team4.model.ProductType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private ProductType productType;
    private String description;
    private Double price;
}
