package com.mercadolibre.pf_be_hisp_w26_t6_martinez.mappers;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.WarehouseDto.WarehouseQuantityDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Warehouse;

public class WarehouseMapper {
    public static WarehouseQuantityDto buildWarehouseQuantityDto(Warehouse warehouse, Integer quantity) {
        return WarehouseQuantityDto.builder()
                .warehouseCode(warehouse.getWarehouseCode())
                .totalQuantity(quantity)
                .build();
    }
}
