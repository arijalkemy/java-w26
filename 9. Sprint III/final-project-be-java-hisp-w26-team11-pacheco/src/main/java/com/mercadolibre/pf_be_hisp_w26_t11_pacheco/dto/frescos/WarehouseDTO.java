package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.frescos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WarehouseDTO {
    private Integer warehouseCode;
    private Long totalQuantity;
}
