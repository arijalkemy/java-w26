package com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums;

import lombok.Getter;

@Getter
public enum SuccessMessageEnum {
    PRODUCTS_CREATED("The list of %s were successfully created"),
    PRODUCTS_UPDATED("The list of %s were successfully updated");

    private final String message;

    SuccessMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage(Long id) {
        return String.format(this.message, id);
    }

    public String getMessage(String additional) {
        return String.format(this.message, additional);
    }
}
