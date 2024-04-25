package org.example.g14.dto;

import lombok.Data;

@Data
public class UserWithPostPromoCount extends UserDto{
    private int promo_products_count;

    public UserWithPostPromoCount(int userId, String name, int countPromoPost){
        super(userId,name);
        this.promo_products_count = countPromoPost;
    }

}
