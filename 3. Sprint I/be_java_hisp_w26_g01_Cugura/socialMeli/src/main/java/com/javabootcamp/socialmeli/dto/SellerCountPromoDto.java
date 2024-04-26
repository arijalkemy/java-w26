package com.javabootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerCountPromoDto {
    
     @JsonProperty("user_id")
     private Integer userId;
     @JsonProperty("user_name")
     private String username;
     @JsonProperty("promo_products_count")
     private Integer promoProductsCount;
}
