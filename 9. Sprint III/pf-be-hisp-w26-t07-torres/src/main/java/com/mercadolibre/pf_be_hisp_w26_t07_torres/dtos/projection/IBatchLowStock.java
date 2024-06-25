package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection;

public interface IBatchLowStock {
    Long getBatchId();
    Long getProductId();
    int getCurrentQuantity();
    int getInitialQuantity();
}
