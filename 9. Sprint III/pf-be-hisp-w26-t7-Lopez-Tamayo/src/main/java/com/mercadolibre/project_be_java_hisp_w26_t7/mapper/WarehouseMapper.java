package com.mercadolibre.project_be_java_hisp_w26_t7.mapper;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.WarehouseResponseDTO;

public class WarehouseMapper {
    public static WarehouseResponseDTO mapToWarehouseResponseDTO(IWarehouseBatchProduct warehouseBatchProduct) {
        return WarehouseResponseDTO.builder()
                .warehouseCode(warehouseBatchProduct.getWarehouseId())
                .totalQuantity(warehouseBatchProduct.getBatchCurrentQuantity())
                .build();
    }
}
