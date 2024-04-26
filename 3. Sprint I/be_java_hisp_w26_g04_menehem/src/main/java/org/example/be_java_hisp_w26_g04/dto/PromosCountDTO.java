package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromosCountDTO {
    @JsonAlias("userId")
    @JsonProperty("user_id")
    private int userId;
    @JsonAlias("userName")
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("promo_products_count")
    private int followersCount;
}
