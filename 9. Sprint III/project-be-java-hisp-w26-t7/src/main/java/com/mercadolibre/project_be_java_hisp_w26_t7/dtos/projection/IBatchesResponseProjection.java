package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection;

import java.time.LocalDate;

public interface IBatchesResponseProjection {

    Integer getBatchNumber();

    LocalDate getDueDate();

    Integer getCurrentQuantity();

    Long getProductId();

    Long getStorageType();

}
