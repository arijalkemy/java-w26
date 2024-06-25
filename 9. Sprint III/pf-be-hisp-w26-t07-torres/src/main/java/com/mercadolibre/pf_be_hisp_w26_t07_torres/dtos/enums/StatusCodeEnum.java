package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.enums;

public enum StatusCodeEnum {
    SUCCESSFUL(1L),
    ERROR(2L);

    private final Long id;
    StatusCodeEnum(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
