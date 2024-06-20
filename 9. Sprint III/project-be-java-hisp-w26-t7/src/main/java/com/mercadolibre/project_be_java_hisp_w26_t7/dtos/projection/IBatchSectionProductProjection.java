package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection;


import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BSResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IBatchSectionProductProjection {


    Integer getBatchNumber();

    Integer getCurrentQuantity();

    LocalDate getDueDate();

    Long getSectionCode();

    Long getWarehouseCode();

    Long getProductId();

    List<BSResponseDTO> getBatchStock();
}
