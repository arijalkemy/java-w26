package com.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PromoCountResponseDto {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("promo_products_count")
    private Integer promoCount;
}