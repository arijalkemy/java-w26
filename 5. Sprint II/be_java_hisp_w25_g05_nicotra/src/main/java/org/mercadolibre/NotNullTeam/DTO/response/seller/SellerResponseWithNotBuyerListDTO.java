package org.mercadolibre.NotNullTeam.DTO.response.seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerResponseWithNotBuyerListDTO {
    private Long user_id;
    private String user_name;
}
