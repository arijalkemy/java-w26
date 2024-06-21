package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BatchStockListResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.SectionAverageTemperature;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.OrderEnum;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.StorageTypeEnum;

public interface IBatchService {
    BatchStockListResponseDTO findBatchesNearExpiry(Integer cantDays, StorageTypeEnum category, OrderEnum order, Integer userId);

    SectionAverageTemperature getBatchAverage(Long sectionId);
}
