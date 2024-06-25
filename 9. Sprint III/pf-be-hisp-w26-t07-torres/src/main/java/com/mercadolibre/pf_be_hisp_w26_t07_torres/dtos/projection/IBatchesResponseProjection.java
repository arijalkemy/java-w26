package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection;

import java.time.LocalDate;

public interface IBatchesResponseProjection {

    Integer getBatchNumber();

    LocalDate getDueDate();

    Integer getCurrentQuantity();

    Long getProductId();

    Long getStorageType();

}
