package org.mercadolibre.NotNullTeam.DTO.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductFilterDTO {

    private String name;
    private String type;
    private String brand;
    private String color;
    private boolean has_promo;
    private Double min_price;
    private Double max_price;

}
