package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.enums.BatchOrderType;

import java.util.List;

public interface IBatchServiceInternal {
    Batch getEntityById(Integer id);
    Boolean DeleteBatchList(List<Batch> batches);

    List<Batch> findAllByProductId(Integer productId);
    List<Batch> findAllByProductIdAndQuantityGreatherThanCero(Integer productId);

    Batch getEntityByIdOrNull(Integer id);
    List<Batch> findAllByProductIdAndWarehouseId(Integer productId, Integer warehouseId);
    List<Batch> findNonExpiredByProductIdAndWarehouseId(Integer productId,
                                                        Integer warehouseId,
                                                        BatchOrderType batchOrderType);
}
