package com.example.sprint1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoQuantityDto {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
