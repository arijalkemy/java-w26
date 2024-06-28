package com.mercadolibre.project_be_java_hisp_w26_t7.mapper;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.WarehouseResponseDTO;

import java.util.List;

public class StockQuantityMapper {
    public static StockQuantityResponseDto mapToStockQuantityResponseDto
            (Integer id, List<WarehouseResponseDTO> warehouseResponseDTO) {
        return StockQuantityResponseDto.builder()
                .productId(id)
                .warehouses(warehouseResponseDTO)
                .build();
    }
}
