package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostPromoCountDto {
    private Long userId;
    private String userName;
    private Integer promo_products_count;
}
