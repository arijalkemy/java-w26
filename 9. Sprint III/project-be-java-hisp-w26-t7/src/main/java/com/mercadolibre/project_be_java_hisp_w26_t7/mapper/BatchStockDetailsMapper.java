package com.mercadolibre.project_be_java_hisp_w26_t7.mapper;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IBatchesResponseProjection;

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


