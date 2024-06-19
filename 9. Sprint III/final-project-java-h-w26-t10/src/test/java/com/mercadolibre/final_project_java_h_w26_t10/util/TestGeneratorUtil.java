package com.mercadolibre.final_project_java_h_w26_t10.util;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.CheckInventoryResponseDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.InventoryByWarehouseDto;

import java.util.List;

public class TestGeneratorUtil {

    public static List<InventoryByWarehouseDto> getInvByWh() {
        return List.of(new InventoryByWarehouseDto(1, 100L));
    }

    public static CheckInventoryResponseDto getCheckInvResponse() {
        return new CheckInventoryResponseDto(1, getInvByWh());
    }

}
