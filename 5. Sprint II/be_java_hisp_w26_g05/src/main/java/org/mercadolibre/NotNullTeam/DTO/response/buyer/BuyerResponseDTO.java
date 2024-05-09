package org.mercadolibre.NotNullTeam.DTO.response.buyer;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerResponseWithNotBuyerListDTO;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuyerResponseDTO {
    @JsonProperty("user_id")
    public Long userId;

    @JsonProperty("user_name")
    public String userName;
    public List<SellerResponseWithNotBuyerListDTO> sellers;
}
