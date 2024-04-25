package com.group03.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.security.Provider;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerPromoPublicationsResponseDTO implements Serializable {
    private Integer userId;
    private String userName;
    private Long promoProductsCount;
}
