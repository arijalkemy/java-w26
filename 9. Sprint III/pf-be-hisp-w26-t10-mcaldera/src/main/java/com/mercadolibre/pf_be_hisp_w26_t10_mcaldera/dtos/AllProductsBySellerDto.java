package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllProductsBySellerDto {
    private Integer product_id;
    private String name;
    private Double price;
    private Integer category_id;
    private String category_name;
}
