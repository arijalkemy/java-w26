package com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos;

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
