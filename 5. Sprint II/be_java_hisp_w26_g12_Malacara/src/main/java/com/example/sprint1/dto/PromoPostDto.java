package com.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PromoPostDto {
    public class PromoPost {

        @JsonProperty("user_id")
        private Integer userId;
        @JsonProperty("user_name")
        private String userName;
        @JsonProperty("promo_products_count")
        private Integer promoProductCount;
    }
}
