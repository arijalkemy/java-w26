package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.enums;

public enum OperationEnum {
    CREATE(1L),
    UPDATE(2L);

    private final Long id;
    OperationEnum(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
