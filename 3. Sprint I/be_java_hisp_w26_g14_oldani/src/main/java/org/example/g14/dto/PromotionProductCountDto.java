package org.example.g14.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionProductCountDto extends UserDto{
    private int promo_products_count;

    public PromotionProductCountDto(int user_id, String user_name, int promo_products_count) {
        super(user_id, user_name);
        this.promo_products_count = promo_products_count;
    }
}
