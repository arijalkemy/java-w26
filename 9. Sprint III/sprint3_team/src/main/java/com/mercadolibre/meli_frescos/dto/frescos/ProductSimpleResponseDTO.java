package com.mercadolibre.meli_frescos.dto.frescos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSimpleResponseDTO {
    private String name;
    private Double price;
}
