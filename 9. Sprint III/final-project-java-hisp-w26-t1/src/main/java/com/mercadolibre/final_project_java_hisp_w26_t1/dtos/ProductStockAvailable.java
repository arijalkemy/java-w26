package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

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
