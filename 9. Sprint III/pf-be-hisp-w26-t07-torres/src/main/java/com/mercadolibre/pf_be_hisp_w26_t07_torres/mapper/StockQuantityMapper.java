package com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.WarehouseResponseDTO;

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
