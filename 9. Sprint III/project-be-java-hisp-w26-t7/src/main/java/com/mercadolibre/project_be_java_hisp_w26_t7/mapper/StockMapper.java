package com.mercadolibre.project_be_java_hisp_w26_t7.mapper;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.stock.StockResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Batch;

public class StockMapper {
    public static StockResponseDTO entityToStockResponse(Batch batch) {
        return StockResponseDTO.builder()
                .batchNumber(batch.getBatchNumber())
                .productId(batch.getProductSeller().getId())
                .manufacturingDate(batch.getManufacturingDate())
                .manufacturingTime(batch.getManufacturingTime())
                .minimumTemperature(Double.parseDouble(batch.getMinimumTemperature().toString()))
                .currentTemperature(Double.parseDouble(batch.getCurrentTemperature().toString()))
                .initialQuantity(batch.getInitialQuantity())
                .dueDate(batch.getDueDate())
                .currentQuantity(batch.getCurrentQuantity())
                .build();
    }
}
