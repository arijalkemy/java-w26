package com.mercadolibre.final_project_java_hisp_w26_t6.services.inboundOrder;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchInsertionRequestDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchInsertionResponseDto;

public interface IInboundOrderService {
    BatchInsertionResponseDto insertBatchInFulfillmentWarehouse(BatchInsertionRequestDto requestDto, boolean update);
}
