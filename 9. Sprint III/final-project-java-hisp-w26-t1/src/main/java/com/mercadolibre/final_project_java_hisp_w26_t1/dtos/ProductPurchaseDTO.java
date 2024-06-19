package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPurchaseDTO {
    Integer product_id;
    Integer quantity;
}
