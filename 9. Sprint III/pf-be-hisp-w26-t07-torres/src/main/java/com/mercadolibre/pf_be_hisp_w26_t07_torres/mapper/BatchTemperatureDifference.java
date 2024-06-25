package com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchTemperatureDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchTemperatures;

import java.util.List;
import java.util.stream.Collectors;

public class BatchTemperatureDifference {
    public static BatchTemperatureDTO toBatchTemperatureDTO(IBatchTemperatures projection) {
        return new BatchTemperatureDTO(
                projection.getBatchId(),
                projection.getProductId(),
                projection.getTemperature(),
                projection.getMinTemperature()
        );
    }

    public static List<BatchTemperatureDTO> toBatchTemperatureDTOs(List<IBatchTemperatures> projections) {
        return projections.stream()
                .map(BatchTemperatureDifference::toBatchTemperatureDTO)
                .collect(Collectors.toList());
    }
}
