package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.*;

import java.util.List;

@Data
public class PromoProductsBySellerResponeseDTO {
    private Long userId;
    private String userName;
    private List<PromoPostResponseDTO> posts;

}
