package com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces;

import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.WarehouseStockResponseDTO;

public interface IWarehouseService {
    WarehouseStockResponseDTO findStockWarehouseByProductId(Integer productId);
}
