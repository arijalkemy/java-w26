package org.example.sprint1.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private int UserId;
    private String customerName;
    private List<BasicSellerDTO> followed;
}
