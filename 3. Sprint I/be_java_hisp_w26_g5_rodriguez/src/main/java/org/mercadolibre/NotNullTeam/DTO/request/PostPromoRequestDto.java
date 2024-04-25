package org.mercadolibre.NotNullTeam.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoRequestDto {
    private Long user_id;
    private String date;
    private ProductDTO product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
