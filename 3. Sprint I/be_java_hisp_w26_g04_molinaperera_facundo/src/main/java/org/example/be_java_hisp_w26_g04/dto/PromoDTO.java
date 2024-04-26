package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PromoDTO {
    @JsonProperty("user_id")
    private int SellerId;
    @JsonProperty("user_name")
    private String sellerName;
    @JsonProperty("promo_products_count")
    private int promoProductsCount;

    public void increasePromoProductCount(){
        this.promoProductsCount+=1;
    }
}