package com.meli.be_java_hisp_w26_g09.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class CountPromosBySellerDTO implements Serializable {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
}
