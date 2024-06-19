package com.mercadolibre.sprint3_individual_perez.service;

import com.mercadolibre.sprint3_individual_perez.dto.response.ResponseBatchDueDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.AllWarehousesDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.WarehouseStockDTO;
import com.mercadolibre.sprint3_individual_perez.enums.Category;


public interface IBatchService {
    ResponseBatchDueDTO getDueBatchesByDays(Integer cantDays);
  
    WarehouseStockDTO getWarehouseStockByProductID(Long id);

    AllWarehousesDTO getAllWarehousesByProductID(Long id);

    WarehouseStockDTO getWarehouseStockByProductIDOrdered(Long id, String order);

    ResponseBatchDueDTO getDueBatchesByDaysAndCategory(Integer cantDays, Category category, String order);
}
