package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.dtos.WarehouseDTO;
import com.mercadolibre.fresh_market.model.Warehouse;

public interface IWarehouseService extends IGenericService<Warehouse> {
    WarehouseDTO getWarehouseByWarehousemanId(Long warehousemanId);
}
