package org.mercadolibre.NotNullTeam.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.model.Product;

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
