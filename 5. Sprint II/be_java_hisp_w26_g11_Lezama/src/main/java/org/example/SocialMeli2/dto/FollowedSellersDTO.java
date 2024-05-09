package org.example.SocialMeli2.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "UserId", "customerName", "followed" })
public class FollowedSellersDTO implements Serializable {
    @JsonProperty("user_id")
    private int UserId;
    @JsonProperty("user_name")
    private String customerName;
    private List<BasicSellerDTO> followed;
}
