package com.mercadolibre.meli_frescos.dto.frescos;

import com.mercadolibre.meli_frescos.model.ProductType;
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
