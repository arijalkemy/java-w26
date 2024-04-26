package org.mercadolibre.NotNullTeam.DTO.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MainProductResponse {
    private Long id;
    private String name;
    private Double price;
    private boolean has_promo;
    private Double discount;
}
