package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductUS6Dto {
    private String product_desc;
    private Double price;
}
