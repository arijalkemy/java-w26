package com.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountDiscountPostsDto {
    @JsonProperty("user_id")
    Integer userId;

    @JsonProperty("userName")
    String userName;

    @JsonProperty("promo_products_count")
    Long promoProductsCount;
}
