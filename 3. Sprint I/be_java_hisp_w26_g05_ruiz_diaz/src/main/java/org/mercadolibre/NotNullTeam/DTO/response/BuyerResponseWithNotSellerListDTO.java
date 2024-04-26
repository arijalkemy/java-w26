package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.model.Post;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerResponseWithNotSellerListDTO {
    private Long id;
    private String name;
    private List<PostWithPromoResponseDTO> favorite_posts;
}
