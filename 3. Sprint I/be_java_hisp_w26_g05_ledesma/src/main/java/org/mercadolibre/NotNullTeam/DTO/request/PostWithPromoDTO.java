package org.mercadolibre.NotNullTeam.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostWithPromoDTO {
    private Long user_id;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
    private boolean has_promo;
    private double discount;
}
