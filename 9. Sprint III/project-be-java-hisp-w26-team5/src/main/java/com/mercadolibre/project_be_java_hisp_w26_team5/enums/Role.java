package com.mercadolibre.project_be_java_hisp_w26_team5.enums;

public enum Role {
    MANAGER, SELLER, BUYER;

    public static Role getRole(String role) {
        return Role.valueOf(role.toUpperCase());
    }
}
