package com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseResponseDTO {
    private Integer warehouse_code;
    private Integer total_quantity;
}
