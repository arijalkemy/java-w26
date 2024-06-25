package com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.WarehouseResponseDTO;

public class WarehouseMapper {
    public static WarehouseResponseDTO mapToWarehouseResponseDTO(IWarehouseBatchProduct warehouseBatchProduct) {
        return WarehouseResponseDTO.builder()
                .warehouseCode(warehouseBatchProduct.getWarehouseId())
                .totalQuantity(warehouseBatchProduct.getBatchCurrentQuantity())
                .build();
    }
}
