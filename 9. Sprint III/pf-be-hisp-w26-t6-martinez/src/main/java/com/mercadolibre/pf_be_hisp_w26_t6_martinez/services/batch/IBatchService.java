package com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.batch;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchStockListResponseDto;

public interface IBatchService {

    BatchStockListResponseDto getBatchesInDueDate(int cantDays, String storageType, String dateSortType);
}
