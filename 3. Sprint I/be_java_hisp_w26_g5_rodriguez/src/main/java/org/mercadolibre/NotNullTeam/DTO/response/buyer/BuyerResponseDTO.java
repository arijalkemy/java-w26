package org.mercadolibre.NotNullTeam.DTO.response.buyer;


import lombok.*;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerResponseWithNotBuyerListDTO;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyerResponseDTO {
    public Long user_id;
    public String user_name;
    public List<SellerResponseWithNotBuyerListDTO> sellers;
}
