package com.mercadolibre.fresh_market.dtos;

import com.mercadolibre.fresh_market.model.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailDTO {
    private Long id;
    private Double price;
    private String description;
}
