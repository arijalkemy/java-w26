package org.mercadolibre.NotNullTeam.DTO.response.seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostPromoResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerPromosResponse {
    private Long user_id;
    private String user_name;
    private List<PostPromoResponse> posts;
}
