package org.example.social_meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCountPromoPostDTO {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
