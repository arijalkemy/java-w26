package com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.WarehouseStockResponseDTO;

public interface IWarehouseService {
    WarehouseStockResponseDTO findStockWarehouseByProductId(Integer productId);
}
