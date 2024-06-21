package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.mapper;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BatchStockRequestDTO;

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
