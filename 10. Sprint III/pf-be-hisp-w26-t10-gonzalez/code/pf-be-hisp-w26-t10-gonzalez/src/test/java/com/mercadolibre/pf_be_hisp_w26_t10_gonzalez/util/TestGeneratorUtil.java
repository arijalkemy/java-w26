package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.util;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.CheckInventoryResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.InventoryByWarehouseDto;

import java.util.List;

public class TestGeneratorUtil {

    public static List<InventoryByWarehouseDto> getInvByWh() {
        return List.of(new InventoryByWarehouseDto(1, 100L));
    }

    public static CheckInventoryResponseDto getCheckInvResponse() {
        return new CheckInventoryResponseDto(1, getInvByWh());
    }

}
