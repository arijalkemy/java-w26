package com.mercadolibre.meli_frescos.dto.frescos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WarehouseDTO {
    private Integer warehouseCode;
    private Long totalQuantity;
}
