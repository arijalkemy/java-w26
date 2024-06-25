package com.mercadolibre.project_be_java_hisp_w26_team4.model.projection;

import java.time.LocalDate;

public interface BatchWithLocation {
    Long getWarehouseId();

    Long getSectionId();

    Long getProductId();

    Long getBatchId();

    Integer getCurrentQuantity();

    LocalDate getDueDate();
}
