package com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchLowStock;

import java.util.List;
import java.util.stream.Collectors;

public class BatchLowStock {
    public static BatchStockDTO toBatchStockDTO(IBatchLowStock projection) {
        return new BatchStockDTO(
                projection.getBatchId(),
                projection.getProductId(),
                projection.getCurrentQuantity(),
                projection.getInitialQuantity()
        );
    }

    public static List<BatchStockDTO> toBatchStockDTOs(List<IBatchLowStock> projections) {
        return projections.stream()
                .map(BatchLowStock::toBatchStockDTO)
                .collect(Collectors.toList());
    }
}
