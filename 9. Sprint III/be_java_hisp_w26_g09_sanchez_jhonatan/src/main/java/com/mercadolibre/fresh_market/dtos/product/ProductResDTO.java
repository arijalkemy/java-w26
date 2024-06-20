package com.mercadolibre.fresh_market.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResDTO implements Serializable {

    private Integer operation;
    private String message;
    private Integer code;

}
