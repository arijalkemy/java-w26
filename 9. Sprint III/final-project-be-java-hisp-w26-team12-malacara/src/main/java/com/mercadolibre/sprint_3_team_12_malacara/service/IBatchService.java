package com.mercadolibre.sprint_3_team_12_malacara.service;

import com.mercadolibre.sprint_3_team_12_malacara.dto.response.ResponseBatchDueDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.AllWarehousesDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.WarehouseStockDTO;
import com.mercadolibre.sprint_3_team_12_malacara.enums.Category;


public interface IBatchService {
    ResponseBatchDueDTO getDueBatchesByDays(Integer cantDays);
  
    WarehouseStockDTO getWarehouseStockByProductID(Long id);

    AllWarehousesDTO getAllWarehousesByProductID(Long id);

    WarehouseStockDTO getWarehouseStockByProductIDOrdered(Long id, String order);

    ResponseBatchDueDTO getDueBatchesByDaysAndCategory(Integer cantDays, Category category, String order);
}
