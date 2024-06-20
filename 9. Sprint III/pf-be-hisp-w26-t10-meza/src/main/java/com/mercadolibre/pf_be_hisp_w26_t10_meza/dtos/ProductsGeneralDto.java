package com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Category;
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
