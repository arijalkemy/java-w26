package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums;

public enum Role {
    MANAGER, SELLER, BUYER;

    public static Role getRole(String role) {
        return Role.valueOf(role.toUpperCase());
    }
}
