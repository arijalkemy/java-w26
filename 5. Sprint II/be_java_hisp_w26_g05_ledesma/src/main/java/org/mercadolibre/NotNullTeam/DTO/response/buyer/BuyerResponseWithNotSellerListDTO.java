package org.mercadolibre.NotNullTeam.DTO.response.buyer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuyerResponseWithNotSellerListDTO {
    private Long id;
    private String name;
}
