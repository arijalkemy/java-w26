package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PromotionsCountByUserResponseDTO {
    @JsonProperty("user_id")
    @JsonAlias("userId")
    private int userId;
    @JsonProperty("user_name")
    @JsonAlias("userName")
    private String userName;
    @JsonProperty("promo_products_count")
    @JsonAlias("promoProductsCount")
    private int promoProductsCount;

}
