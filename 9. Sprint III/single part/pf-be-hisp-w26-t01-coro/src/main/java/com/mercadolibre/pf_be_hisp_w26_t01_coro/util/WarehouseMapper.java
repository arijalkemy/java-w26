package com.mercadolibre.pf_be_hisp_w26_t01_coro.util;


import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Warehouse;

public class WarehouseMapper {
    public static Warehouse toWarehouseWithManager(WarehouseRequestDTO dto, User manager){
        return Warehouse.builder()
                .name(dto.getName())
                .city(dto.getCity())
                .province(dto.getProvince())
                .manager(manager)
                .build();
    }
}
