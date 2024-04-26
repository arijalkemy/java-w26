package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionPostListOfASellerResponseDTO {
    Long user_id;
    String user_name;
    List<PostWithPromoResponseDTO> postWithPromoResponseDTOList;
}
