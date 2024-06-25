package com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums;

public enum RoleEnumUtil {
    BUYER,
    SELLER,
    REPRESENTATIVE;

    public static RoleEnumUtil fromString(String role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        try {
            return RoleEnumUtil.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
