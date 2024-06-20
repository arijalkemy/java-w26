package com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSellerRequestDTO {
    private String product_desc;
    private Double price;
}
