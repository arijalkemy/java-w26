package com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces;



import com.mercadolibre.pf_be_hisp_w26_t01_moises.Enum.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.Enum.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.BatchStockResponseDTO;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductLocationDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseDTO;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Batch;


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
