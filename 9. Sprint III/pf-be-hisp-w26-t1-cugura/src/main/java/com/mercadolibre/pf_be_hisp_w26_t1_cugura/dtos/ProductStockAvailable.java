package com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockAvailable {
    private Integer id;
    private Integer quantity;
    private Double individualPrice;
}
