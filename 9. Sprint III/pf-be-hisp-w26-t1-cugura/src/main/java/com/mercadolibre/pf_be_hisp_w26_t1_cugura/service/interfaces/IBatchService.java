package com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces;



import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.BatchStockResponseDTO;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.enums.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.enums.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductPurchaseDTO;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.Batch;


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
