package org.mercadolibre.NotNullTeam.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.response.PostResponseDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostWithPromoDto {
    private Long user_id;
    private Long post_id;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
