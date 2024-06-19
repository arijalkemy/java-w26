package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.frescos;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.ProductType;
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
