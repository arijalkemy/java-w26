package org.mercadolibre.NotNullTeam.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long user_id;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
