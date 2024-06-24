package com.mercadolibre.project_java_w26_team13.util;


import lombok.Getter;

@Getter
public enum Roles
{
    REPRESENTANTE("representante"),
    BUYER("buyer");

    private final String role;

    Roles (String role){
        this.role = role;
    }

}
