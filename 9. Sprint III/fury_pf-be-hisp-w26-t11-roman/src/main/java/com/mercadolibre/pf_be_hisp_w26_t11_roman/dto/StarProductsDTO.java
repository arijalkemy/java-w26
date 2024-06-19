package com.mercadolibre.pf_be_hisp_w26_t11_roman.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StarProductsDTO {
    private Integer productId;
    private Long savedQuantity;
    private  Long savedOrders;
}
