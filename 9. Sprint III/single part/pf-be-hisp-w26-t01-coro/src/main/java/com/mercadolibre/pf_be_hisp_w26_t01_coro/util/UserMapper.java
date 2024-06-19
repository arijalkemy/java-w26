package com.mercadolibre.pf_be_hisp_w26_t01_coro.util;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.ManagerRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;

public class UserMapper {
    public static User mapToUser(ManagerRequestDTO managerRequestDTO) {
        return User.builder()
                .username(managerRequestDTO.getName())
                .email(managerRequestDTO.getEmail())
                .password(managerRequestDTO.getPassword())
                .build();
    }
}
