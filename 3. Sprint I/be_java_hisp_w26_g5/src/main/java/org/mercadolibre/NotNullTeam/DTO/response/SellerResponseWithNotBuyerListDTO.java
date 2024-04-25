package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerResponseWithNotBuyerListDTO {
    private Long user_id;
    private String user_name;
}
