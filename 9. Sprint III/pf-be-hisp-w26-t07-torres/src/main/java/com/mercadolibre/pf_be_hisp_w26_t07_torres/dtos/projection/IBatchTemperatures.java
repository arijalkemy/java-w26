package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection;

public interface IBatchTemperatures {
    Long getBatchId();

    Long getProductId();

    double getTemperature();

    double getMinTemperature();
}
