package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Section;

public interface ISectionServiceInternal {
    Section searchById(Integer id);
    Section searchByIdAndWarehouseId(Integer id, Integer warehouseId);
    Section searchAndValidateByWarehouseAndQuantity (int idSection, int idWarehouse, int newBatches);

}
