package com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchesResponseProjection;

public class BatchStockDetailsMapper {

    public static BatchStockDetailsResponseDTO mapBatchStockDetailsResponseDto(IBatchesResponseProjection product) {
        return BatchStockDetailsResponseDTO.builder()
                .batchNumber(product.getBatchNumber())
                .currentQuantity(product.getCurrentQuantity())
                .productId(product.getProductId().intValue())
                .dueDate(product.getDueDate())
                .productTypeId(product.getStorageType().intValue())
                .build();
    }
}
