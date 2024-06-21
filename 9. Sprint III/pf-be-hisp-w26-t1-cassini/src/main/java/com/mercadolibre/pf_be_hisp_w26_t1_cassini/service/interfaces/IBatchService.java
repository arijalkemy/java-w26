package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t1_cassini.Enum.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.Enum.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.enums.OrderBatchEnum;

import java.util.List;

public interface IBatchService {
    Integer countBatchesBySection(Integer sectionId);

    Double checkProductStock(List<ProductPurchaseDTO> idProducts);
    List<BatchStockDTO> addBatchesList(List<Batch> batchesList);

    List<BatchStockDTO> addOrUpdateBatchesList(List<Batch> batchesList);


    BatchStockResponseDTO getBatchesCloseToExpiration(Integer cantOfDays,
                                                      CategoryEnum category,
                                                      OrderTypeEnum orderType);
    BatchStockDTO updateBatchTemperature(Integer batchId,
                                         BatchUpdateTemperatureReqDTO batchUpdateTemperatureReqDTO,
                                         String managerEmail);


    ProductLocationDTO getProductLocation(String managerEmail, Integer id, BatchOrderType batchOrderType);
    BatchWrongTemperatureRespDTO getBatchesWrongTemperature(Integer productId,
                                                            String managerEmail,
                                                            OrderBatchEnum orderBatchEnum);


}
