package org.example.g14.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWithPromoPostsCountDto {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
