package com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces;



import com.mercadolibre.pf_be_hisp_w26_t01_arguello.Enum.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.Enum.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchStockResponseDTO;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductPurchaseDTO;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Batch;


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
