package com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseTotalPriceDTO {
    Double total_price;
}
