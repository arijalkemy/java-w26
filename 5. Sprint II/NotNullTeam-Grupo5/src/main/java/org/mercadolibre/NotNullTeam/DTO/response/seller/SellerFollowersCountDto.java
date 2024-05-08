package org.mercadolibre.NotNullTeam.DTO.response.seller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SellerFollowersCountDto {
        @JsonProperty("user_id")
        private Long userId;

        @JsonProperty("user_name")
        private String userName;

        @JsonProperty("followers_count")
        private int followersCount;

}
