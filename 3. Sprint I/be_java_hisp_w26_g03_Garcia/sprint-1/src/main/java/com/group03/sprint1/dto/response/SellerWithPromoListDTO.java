package com.group03.sprint1.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.group03.sprint1.dto.PublicationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerWithPromoListDTO {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("posts")
    private List<PublicationDTO> promoList;
}
