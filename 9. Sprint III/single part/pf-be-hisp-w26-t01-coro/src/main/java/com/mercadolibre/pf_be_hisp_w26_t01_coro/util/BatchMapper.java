package com.mercadolibre.pf_be_hisp_w26_t01_coro.util;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.BatchLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Product;

public class BatchMapper {
    public static BatchLocationDTO toBatchLocationDTO(Batch batch) {
        return BatchLocationDTO.builder()
                .batch_number(batch.getId())
                .current_quantity(batch.getCurrentQuantity())
                .due_date(batch.getDueDate())
                .build();
    }
    public static BatchStockDTO toBatchStockDTO(Batch batch){
        return BatchStockDTO.builder()
                .batch_number(batch.getId())
                .product_id(batch.getProduct().getId())
                .current_temperature(batch.getCurrentTemperature())
                .minimum_temperature(batch.getMinimumTemperature())
                .initial_quantity(batch.getInitialQuantity())
                .current_quantity(batch.getCurrentQuantity())
                .manufacturing_date(batch.getManufacturingDate())
                .manufacturing_time(batch.getManufacturingTime())
                .due_date(batch.getDueDate()).build();
    }
    public static Batch toBatch(BatchStockDTO dto, Product product){
         return Batch.builder()
                .id(dto.getBatch_number())
                .product(product)
                .currentTemperature(dto.getCurrent_temperature())
                .minimumTemperature(dto.getMinimum_temperature())
                .initialQuantity(dto.getInitial_quantity())
                .currentQuantity(dto.getCurrent_quantity())
                .manufacturingDate(dto.getManufacturing_date())
                .manufacturingTime(dto.getManufacturing_time())
                .dueDate(dto.getDue_date()).build();
    }
}
