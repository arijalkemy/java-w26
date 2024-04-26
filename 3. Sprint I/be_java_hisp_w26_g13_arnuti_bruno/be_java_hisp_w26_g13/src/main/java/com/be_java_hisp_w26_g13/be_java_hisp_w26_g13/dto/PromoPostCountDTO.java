package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PromoPostCountDTO {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("promo_products_count")
    private int promoProductsCount;

}
