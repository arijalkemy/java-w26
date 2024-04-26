package com.api.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellersCountProductsPromoDTO {
    private Integer user_id;
    private String user_name;
    private Long promo_products_count;
}
