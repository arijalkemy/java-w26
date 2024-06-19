package com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.ResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseStockResponseDTO;

public interface IWarehouseService {
    WarehouseStockResponseDTO findStockWarehouseByProductId(Integer productId);
    ResponseDto createWarehouse(WarehouseRequestDTO warehouseRequestDTO);
}
