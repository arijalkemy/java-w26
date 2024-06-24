package com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.inboundOrder;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchInsertionRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchInsertionResponseDto;

public interface IInboundOrderService {
    BatchInsertionResponseDto insertBatchInFulfillmentWarehouse(BatchInsertionRequestDto requestDto, boolean update);
}
