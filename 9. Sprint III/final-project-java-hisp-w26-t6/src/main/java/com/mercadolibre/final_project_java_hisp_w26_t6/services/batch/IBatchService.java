package com.mercadolibre.final_project_java_hisp_w26_t6.services.batch;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchStockListResponseDto;

public interface IBatchService {

    BatchStockListResponseDto getBatchesInDueDate(int cantDays, String storageType, String dateSortType);
}
