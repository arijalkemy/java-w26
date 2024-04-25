package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.ProductDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDTO {
    private Long user_id;
    private Long post_id;
    private String date;
    ProductDTO product;
    private int category;
    private Double price;
}
