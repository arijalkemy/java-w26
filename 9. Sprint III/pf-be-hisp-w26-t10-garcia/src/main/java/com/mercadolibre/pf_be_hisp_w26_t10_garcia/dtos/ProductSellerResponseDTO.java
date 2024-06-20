package com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSellerResponseDTO {
    private Integer product_id;
    private String product_desc;
    private Double price;
}
