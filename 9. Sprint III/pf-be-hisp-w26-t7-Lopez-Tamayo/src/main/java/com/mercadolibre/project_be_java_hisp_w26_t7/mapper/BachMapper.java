package com.mercadolibre.project_be_java_hisp_w26_t7.mapper;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Batch;

import java.math.BigDecimal;

public class BachMapper {
    public static Batch requestDtoToEntity(BatchStockRequestDTO dto) {
        return Batch.builder()
                .batchNumber(dto.getBatchNumber())
                .currentTemperature(BigDecimal.valueOf(dto.getCurrentTemperature()))
                .minimumTemperature(BigDecimal.valueOf(dto.getMinimumTemperature()))
                .initialQuantity(dto.getInitialQuantity())
                .currentQuantity(dto.getCurrentQuantity())
                .manufacturingDate(dto.getManufacturingDate())
                .manufacturingTime(dto.getManufacturingTime())
                .dueDate(dto.getDueDate())
                .build();
    }
}
