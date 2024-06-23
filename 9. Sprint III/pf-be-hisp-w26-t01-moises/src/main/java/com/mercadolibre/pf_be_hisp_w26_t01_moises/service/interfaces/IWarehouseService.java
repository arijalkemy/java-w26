package com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.WarehouseStockResponseDTO;

public interface IWarehouseService {
    WarehouseStockResponseDTO findStockWarehouseByProductId(Integer productId);
}
