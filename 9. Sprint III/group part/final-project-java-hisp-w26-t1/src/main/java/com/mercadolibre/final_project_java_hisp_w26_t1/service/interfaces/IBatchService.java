package com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces;



import com.mercadolibre.final_project_java_hisp_w26_t1.Enum.CategoryEnum;
import com.mercadolibre.final_project_java_hisp_w26_t1.Enum.OrderTypeEnum;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.BatchStockDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.BatchStockResponseDTO;

import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.BatchStockDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductLocationDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.enums.BatchOrderType;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.BatchStockResponseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductPurchaseDTO;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Batch;


import java.util.List;

public interface IBatchService {
    Integer countBatchesBySection(Integer sectionId);

    Double checkProductStock(List<ProductPurchaseDTO> idProducts);
    List<BatchStockDTO> addBatchesList(List<Batch> batchesList);

    List<BatchStockDTO> addOrUpdateBatchesList(List<Batch> batchesList);


    BatchStockResponseDTO getBatchesCloseToExpiration(Integer cantOfDays,
                                                      CategoryEnum category,
                                                      OrderTypeEnum orderType);



    ProductLocationDTO getProductLocation(String managerEmail, Integer id, BatchOrderType batchOrderType);


}
