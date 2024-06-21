package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.mapper;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.stock.StockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Batch;

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
