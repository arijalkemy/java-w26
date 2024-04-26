package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PromosCountDTO {
    private Long user_id;
    private String user_name;
    private int promo_products_count;
}
