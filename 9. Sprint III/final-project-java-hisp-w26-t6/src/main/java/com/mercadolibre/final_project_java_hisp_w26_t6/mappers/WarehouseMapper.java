package com.mercadolibre.final_project_java_hisp_w26_t6.mappers;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.WarehouseDto.WarehouseQuantityDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Warehouse;

public class WarehouseMapper {
    public static WarehouseQuantityDto buildWarehouseQuantityDto(Warehouse warehouse, Integer quantity) {
        return WarehouseQuantityDto.builder()
                .warehouseCode(warehouse.getWarehouseCode())
                .totalQuantity(quantity)
                .build();
    }
}
