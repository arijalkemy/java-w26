package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ProductsPromoCountDTO {
    private Long userId;
    private String userName;
    private int quantityOfPromoProducts;
}
