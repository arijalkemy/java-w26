package com.mercadolibre.fresh_market.service.impl;

import com.mercadolibre.fresh_market.dtos.WarehouseDTO;
import com.mercadolibre.fresh_market.model.Warehouse;
import com.mercadolibre.fresh_market.repository.IWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl {
    @Autowired
    IWarehouseRepository warehouseRepository;

    public WarehouseDTO getWarehouseByWarehousemanId(Long warehousemanId) {
        Warehouse warehouse = warehouseRepository.findWarehouseByWarehousemanId(warehousemanId);
        return new WarehouseDTO(warehouse.getId());
    }
}
