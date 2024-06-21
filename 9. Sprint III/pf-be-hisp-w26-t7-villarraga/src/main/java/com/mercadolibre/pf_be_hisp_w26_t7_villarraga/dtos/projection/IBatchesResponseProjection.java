package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection;

import java.time.LocalDate;

public interface IBatchesResponseProjection {

    Integer getBatchNumber();

    LocalDate getDueDate();

    Integer getCurrentQuantity();

    Long getProductId();

    Long getStorageType();

}
