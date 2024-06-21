package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.WarehouseStockResponseDTO;

public interface IWarehouseService {
    WarehouseStockResponseDTO findStockWarehouseByProductId(Integer productId);
}
