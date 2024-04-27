package org.example.be_java_hisp_w26_g07.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@Data
public class UserProductsPromotion {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("promo_products_count")
    private Integer promo_products_count;
}
