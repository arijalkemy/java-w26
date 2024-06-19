package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service;


import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Warehouse;

public interface IWarehouseService {
    Warehouse findById(Integer id);
}
