package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.WarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Warehouse;

import java.util.List;

public interface IWarehouseService {
    Warehouse findById(Integer id);
    List<WarehouseDto> getWhBySupervisor(Long supervisor_id);
}
