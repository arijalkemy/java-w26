package com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockAvailable {
    private Integer id;
    private Integer quantity;
    private Double individualPrice;
}
