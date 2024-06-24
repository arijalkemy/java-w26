package com.mercadolibre.pf_be_hisp_w26_t6_martinez.mappers;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.SectionDto.SectionDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Warehouse;

public class SectorMapper {
    public static SectionDto toDto(Sector sector, Warehouse warehouse) {
        return SectionDto.builder()
                .sectionCode(sector.getSectorCode())
                .warehouseCode(warehouse.getWarehouseCode())
                .build();
    }
}
