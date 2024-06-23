package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.mapper;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.BatchRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.BatchResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Sector;

public class BatchMapper {

    public static Batch BatchRequestDTOToBatch(
            BatchRequestDTO batchRequestDTO,
            Product product,
            Sector sector
    ) {
        return Batch.builder()
                .batchNumber(batchRequestDTO.getBatchNumber())
                .currentTemperature(batchRequestDTO.getCurrentTemperature())
                .minimumTemperature(batchRequestDTO.getMinimumTemperature())
                .initialQuantity(batchRequestDTO.getInitialQuantity())
                .currentQuantity(batchRequestDTO.getCurrentQuantity())
                .dueDate(batchRequestDTO.getDueDate())
                .manufacturingDate(batchRequestDTO.getManufacturingDate())
                .manufacturingTime(batchRequestDTO.getManufacturingTime())
                .product(product)
                .sector(sector)
                .build();
    }

    public static BatchResponseDTO BatchToBatchResponseDTO(Batch batch) {
        return BatchResponseDTO.builder()
                .batchNumber(batch.getBatchNumber())
                .idProduct(batch.getProduct().getId())
                .currentTemperature(batch.getCurrentTemperature())
                .minimumTemperature(batch.getMinimumTemperature())
                .initialQuantity(batch.getInitialQuantity())
                .currentQuantity(batch.getCurrentQuantity())
                .manufacturingDate(batch.getManufacturingDate())
                .manufacturingTime(batch.getManufacturingTime())
                .dueDate(batch.getDueDate())
                .build();
    }

    public static BatchRequestDTO BatchToBatchRequestDTO(Batch batch) {
        return BatchRequestDTO.builder()
                .batchNumber(batch.getBatchNumber())
                .idProduct(batch.getProduct().getId())
                .currentTemperature(batch.getCurrentTemperature())
                .minimumTemperature(batch.getMinimumTemperature())
                .initialQuantity(batch.getInitialQuantity())
                .currentQuantity(batch.getCurrentQuantity())
                .manufacturingDate(batch.getManufacturingDate())
                .manufacturingTime(batch.getManufacturingTime())
                .dueDate(batch.getDueDate())
                .build();
    }
}
