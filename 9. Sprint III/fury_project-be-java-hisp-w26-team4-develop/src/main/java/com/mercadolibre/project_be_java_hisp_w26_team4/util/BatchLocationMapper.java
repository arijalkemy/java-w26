package com.mercadolibre.project_be_java_hisp_w26_team4.util;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.BatchInfoDto;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductLocationDto;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.SectionDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.projection.BatchWithLocation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BatchLocationMapper {

    public static List<ProductLocationDto> createProductLocationDtos(
            Map<Long, List<BatchWithLocation>> locationsByWarehouse
    ) {
        List<ProductLocationDto> productLocations = new ArrayList<>();

        locationsByWarehouse.forEach((warehouseId, batches) ->
                productLocations.add(createProductLocationDto(batches))
        );

        return productLocations;
    }

    private static ProductLocationDto createProductLocationDto(List<BatchWithLocation> locations) {
        SectionDTO section = SectionDTO.builder()
                .sectionId(locations.get(0).getSectionId())
                .warehouseId(locations.get(0).getWarehouseId())
                .build();

        List<BatchInfoDto> batches = locations.stream()
                .map(BatchLocationMapper::createBatchInfoDto)
                .toList();

        return ProductLocationDto.builder()
                .section(section)
                .productId(locations.get(0).getProductId())
                .batches(batches)
                .build();
    }

    private static BatchInfoDto createBatchInfoDto(BatchWithLocation batch) {
        return BatchInfoDto.builder()
                .id(batch.getBatchId())
                .currentQuantity(batch.getCurrentQuantity())
                .dueDate(batch.getDueDate())
                .build();
    }
}
