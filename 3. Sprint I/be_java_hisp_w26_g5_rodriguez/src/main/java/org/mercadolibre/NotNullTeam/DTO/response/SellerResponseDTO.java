package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SellerResponseDTO {
    private Long id;
    private String name;
    private List<BuyerResponseWithNotSellerListDTO> followers;
}