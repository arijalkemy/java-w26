package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection;


import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BSResponseDTO;

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
