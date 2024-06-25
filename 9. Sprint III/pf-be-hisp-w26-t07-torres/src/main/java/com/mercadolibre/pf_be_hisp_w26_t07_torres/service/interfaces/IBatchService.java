package com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchTemperatureDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.OrderEnum;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.StorageTypeEnum;

import java.util.List;

public interface IBatchService {
    BatchStockListResponseDTO findBatchesNearExpiry(Integer cantDays, StorageTypeEnum category, OrderEnum order, Integer userId);
    List<BatchTemperatureDTO> getBatchesWithTemperatureDifference();
    List<BatchStockDTO> getBatchesLowStock();
}
