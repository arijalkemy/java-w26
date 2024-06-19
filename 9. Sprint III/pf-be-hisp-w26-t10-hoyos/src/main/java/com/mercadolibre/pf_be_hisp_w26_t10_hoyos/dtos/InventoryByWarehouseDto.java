package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryByWarehouseDto {
    private Integer warehouse_code;
    private Long total_quantity;
}