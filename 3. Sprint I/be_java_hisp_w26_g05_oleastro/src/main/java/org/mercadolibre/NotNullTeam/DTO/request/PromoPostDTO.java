package org.mercadolibre.NotNullTeam.DTO.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO {
    private Long user_id;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
    private boolean has_promo;
    private Double discount;
}
