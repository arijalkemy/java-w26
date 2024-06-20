package com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailDTO {
    private String name;
    private Integer quantity;
    private Double price;
}
