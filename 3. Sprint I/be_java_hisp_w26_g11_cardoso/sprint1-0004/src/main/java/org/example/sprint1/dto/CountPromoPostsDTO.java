package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountPromoPostsDTO {
    @JsonProperty("user_id")
    private int sellerId;
    @JsonProperty("user_name")
    private String sellerName;
    @JsonProperty("promo_products_count")
    private int countPromoPosts;
}
