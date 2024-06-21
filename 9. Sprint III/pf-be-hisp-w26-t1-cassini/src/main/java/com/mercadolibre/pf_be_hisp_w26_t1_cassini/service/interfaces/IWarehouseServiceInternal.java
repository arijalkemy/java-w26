package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Warehouse;

import java.util.List;

public interface IWarehouseServiceInternal {
    Warehouse findWarehouseById(Integer warehouseId);
    List<Warehouse> findAllWarehouses();

}
