package org.mercadolibre.NotNullTeam.DTO.request.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long user_id;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
}
