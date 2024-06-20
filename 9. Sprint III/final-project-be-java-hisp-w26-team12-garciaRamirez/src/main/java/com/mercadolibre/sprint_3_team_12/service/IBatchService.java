package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.response.*;
import com.mercadolibre.sprint_3_team_12.enums.Category;

import java.util.List;


public interface IBatchService {
    ResponseBatchDueDTO getDueBatchesByDays(Integer cantDays);
  
    WarehouseStockDTO getWarehouseStockByProductID(Long id);

    AllWarehousesDTO getAllWarehousesByProductID(Long id);

    WarehouseStockDTO getWarehouseStockByProductIDOrdered(Long id, String order);

    ResponseBatchDueDTO getDueBatchesByDaysAndCategory(Integer cantDays, Category category, String order);

    List<ScarceWarehouseDTO> getAllScarceProducts(Long scarceLimit);
}
