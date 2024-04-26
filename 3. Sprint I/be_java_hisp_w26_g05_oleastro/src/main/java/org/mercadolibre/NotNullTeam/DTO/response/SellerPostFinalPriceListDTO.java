package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerPostFinalPriceListDTO {
    private Long user_id;
    private String user_name;
    private List<PostFinalPriceDTO> posts;
}
