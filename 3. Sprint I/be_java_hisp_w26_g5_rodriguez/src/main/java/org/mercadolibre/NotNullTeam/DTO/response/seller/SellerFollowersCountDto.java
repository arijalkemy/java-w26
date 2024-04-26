package org.mercadolibre.NotNullTeam.DTO.response.seller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SellerFollowersCountDto {
        private Long user_id;
        private String user_name;
        private int followers_count;

}
