package com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Warehouse;

import java.util.List;

public interface IWarehouseServiceInternal {
    Warehouse findWarehouseById(Integer warehouseId);
    List<Warehouse> findAllWarehouses();

}
