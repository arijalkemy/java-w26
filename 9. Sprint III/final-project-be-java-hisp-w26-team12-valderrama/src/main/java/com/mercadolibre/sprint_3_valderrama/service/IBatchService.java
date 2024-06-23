package com.mercadolibre.sprint_3_valderrama.service;

import com.mercadolibre.sprint_3_valderrama.dto.response.ResponseBatchDueDTO;
import com.mercadolibre.sprint_3_valderrama.dto.response.AllWarehousesDTO;
import com.mercadolibre.sprint_3_valderrama.dto.response.WarehouseStockDTO;
import com.mercadolibre.sprint_3_valderrama.enums.Category;


public interface IBatchService {
    ResponseBatchDueDTO getDueBatchesByDays(Integer cantDays);

    WarehouseStockDTO getWarehouseStockByProductID(Long id);

    AllWarehousesDTO getAllWarehousesByProductID(Long id);

    WarehouseStockDTO getWarehouseStockByProductIDOrdered(Long id, String order);

    ResponseBatchDueDTO getDueBatchesByDaysAndCategory(Integer cantDays, Category category, String order);

    ResponseBatchDueDTO getExpiredBatches(Long warehouseId);

    ResponseBatchDueDTO getOutedBatches(Long warehouseId);




}
