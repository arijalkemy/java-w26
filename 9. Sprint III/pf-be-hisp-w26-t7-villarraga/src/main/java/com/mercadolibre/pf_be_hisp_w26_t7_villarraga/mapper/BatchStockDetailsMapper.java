package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.mapper;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BatchStockDetailsResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IBatchesResponseProjection;

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


