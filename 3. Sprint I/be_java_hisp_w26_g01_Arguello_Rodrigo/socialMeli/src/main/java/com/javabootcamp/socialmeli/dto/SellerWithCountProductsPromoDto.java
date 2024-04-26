package com.javabootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SellerWithCountProductsPromoDto {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("promo_products_count")
    private long promoProductsCount;
}
