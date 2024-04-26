package org.mercadolibre.NotNullTeam.DTO.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.ProductDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostWithPromoResponseDTO {
    private Long post_id;
    private Long user_id;
    private String date;
    private ProductDTO product;
    private int category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
