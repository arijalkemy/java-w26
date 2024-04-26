package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.mercadolibre.NotNullTeam.DTO.request.ProductDTO;

@Data
@AllArgsConstructor
public class PostResponseWithPromoDTO {
    private Long user_id;
    private Long post_id;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
    private boolean has_promo;
    private double discount;
}
