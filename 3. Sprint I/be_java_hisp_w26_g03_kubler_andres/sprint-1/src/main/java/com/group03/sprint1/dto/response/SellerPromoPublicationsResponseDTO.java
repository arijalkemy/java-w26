package com.group03.sprint1.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.group03.sprint1.dto.PublicationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.security.Provider;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerPromoPublicationsResponseDTO implements Serializable {
    private Integer userId;
    private String userName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long promoProductsCount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PublicationDTO> publications;
}
