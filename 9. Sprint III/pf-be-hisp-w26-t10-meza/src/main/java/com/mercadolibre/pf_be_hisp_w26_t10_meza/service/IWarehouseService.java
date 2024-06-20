package com.mercadolibre.pf_be_hisp_w26_t10_meza.service;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseResponseInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseResponseRegisterDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Warehouse;

public interface IWarehouseService {
    Warehouse findById(Integer id);

    WarehouseResponseRegisterDto registerWarehouse(WarehouseInfoDto warehouseInfoDto);

    WarehouseResponseInfoDto findOneWarehouse(Integer id);
}
