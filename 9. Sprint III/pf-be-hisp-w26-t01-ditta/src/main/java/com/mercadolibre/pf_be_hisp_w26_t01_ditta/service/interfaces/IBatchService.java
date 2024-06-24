package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t01_ditta.Enum.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.Enum.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.ProductLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.ProductPurchaseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.enums.BatchOrderType;

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
