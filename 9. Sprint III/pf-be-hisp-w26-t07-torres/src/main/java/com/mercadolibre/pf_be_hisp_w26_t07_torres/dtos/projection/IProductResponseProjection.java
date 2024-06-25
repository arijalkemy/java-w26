package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection;

public interface IProductResponseProjection {

    Long getId();

    String getDescription();

    Double getPrice();

    String getSellerName();

    String getCategory();
}
