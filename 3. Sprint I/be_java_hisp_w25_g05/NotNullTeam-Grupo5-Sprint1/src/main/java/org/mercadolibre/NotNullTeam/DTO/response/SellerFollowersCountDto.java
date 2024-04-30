package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SellerFollowersCountDto {
        private Long user_id;
        private String user_name;
        private int followers_count;

}
