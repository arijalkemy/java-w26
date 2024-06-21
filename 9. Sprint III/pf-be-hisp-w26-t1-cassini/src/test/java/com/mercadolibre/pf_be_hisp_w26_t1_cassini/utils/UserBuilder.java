package com.mercadolibre.pf_be_hisp_w26_t1_cassini.utils;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Role;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.User;

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
