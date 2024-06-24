package com.mercadolibre.final_project_java_hisp_w26_t6.mappers;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.SectionDto.SectionDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Sector;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Warehouse;

public class SectorMapper {
    public static SectionDto toDto(Sector sector, Warehouse warehouse) {
        return SectionDto.builder()
                .sectionCode(sector.getSectorCode())
                .warehouseCode(warehouse.getWarehouseCode())
                .build();
    }
}
