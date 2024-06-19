package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos;

import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private ProductType productType;
    private Integer quantity;
}
