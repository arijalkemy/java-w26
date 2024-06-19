package com.mercadolibre.fresh_market.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    WAREHOUSEMAN("Warehouseman"),
    BUYER("Buyer"),
    SELLER("Seller");
    private String name;
}
