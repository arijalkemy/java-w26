package com.mercadolibre.fresh_market.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Category {
    FF(1, "Frozen"),
    RF(2, "Cooled"),
    FS(3, "Fresh");

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }
}
