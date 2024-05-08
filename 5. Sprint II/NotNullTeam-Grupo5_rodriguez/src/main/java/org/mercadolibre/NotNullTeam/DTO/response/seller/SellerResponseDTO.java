package org.mercadolibre.NotNullTeam.DTO.response.seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerResponseDTO {
    private Long id;
    private String name;
    private List<BuyerResponseWithNotSellerListDTO> followers;
}