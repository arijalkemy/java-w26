package com.mercadolibre.final_project_java_hisp_w26_t1.utils;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Role;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.User;

public class UserBuilder {
    private UserBuilder(){}

    public static User getUser(){
        return User.builder()
                .email("defaultmail.com")
                .password("pass")
                .role(new Role(1,"Buyer","Buyer role"))
                .username("Buyer")
                .build();
    }
}
