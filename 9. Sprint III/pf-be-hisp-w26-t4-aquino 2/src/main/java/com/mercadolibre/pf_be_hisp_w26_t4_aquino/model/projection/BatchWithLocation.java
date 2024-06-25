package com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.projection;

import java.time.LocalDate;

public interface BatchWithLocation {
    Long getWarehouseId();

    Long getSectionId();

    Long getProductId();

    Long getBatchId();

    Integer getCurrentQuantity();

    LocalDate getDueDate();
}
