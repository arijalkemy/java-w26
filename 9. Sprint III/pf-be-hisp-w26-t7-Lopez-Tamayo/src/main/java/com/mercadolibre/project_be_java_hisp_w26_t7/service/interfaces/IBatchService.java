package com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces;


import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.OrderEnum;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.StorageTypeEnum;

public interface IBatchService {
    BatchStockListResponseDTO findBatchesNearExpiry(Integer cantDays, StorageTypeEnum category, OrderEnum order, Integer userId);
}
