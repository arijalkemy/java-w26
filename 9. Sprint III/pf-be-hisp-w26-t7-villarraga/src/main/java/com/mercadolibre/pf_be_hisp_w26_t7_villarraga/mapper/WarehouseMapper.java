package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.mapper;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.warehouse.WarehouseResponseDTO;

public class WarehouseMapper {
    public static WarehouseResponseDTO mapToWarehouseResponseDTO(IWarehouseBatchProduct warehouseBatchProduct) {
        return WarehouseResponseDTO.builder()
                .warehouseCode(warehouseBatchProduct.getWarehouseId())
                .totalQuantity(warehouseBatchProduct.getBatchCurrentQuantity())
                .build();
    }
}
