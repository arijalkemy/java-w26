package org.example.SocialMeli2.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "user_name", "followers"})
public class SellerFollowerDto implements Serializable {
    @JsonProperty("user_id")
    private int UserId;
    @JsonProperty("user_name")
    private String sellerName;
    private List<BasicCustomerDto> followers;
}
