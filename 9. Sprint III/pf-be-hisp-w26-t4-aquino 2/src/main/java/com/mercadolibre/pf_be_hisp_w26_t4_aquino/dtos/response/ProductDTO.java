package com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.ProductType;
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
