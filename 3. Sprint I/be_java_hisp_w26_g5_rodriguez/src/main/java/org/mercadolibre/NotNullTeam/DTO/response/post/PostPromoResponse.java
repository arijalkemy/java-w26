package org.mercadolibre.NotNullTeam.DTO.response.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoResponse {
    private Long user_id;
    private Long post_id;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
    private boolean has_promo;
    private double discount;
}
