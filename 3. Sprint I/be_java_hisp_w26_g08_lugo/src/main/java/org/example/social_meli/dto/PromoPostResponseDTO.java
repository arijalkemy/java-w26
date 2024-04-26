package org.example.social_meli.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PromoPostResponseDTO {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
