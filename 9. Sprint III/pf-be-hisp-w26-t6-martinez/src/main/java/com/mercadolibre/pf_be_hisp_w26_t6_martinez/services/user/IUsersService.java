package com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.user;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.UserDto.RegisterUserDto;

public interface IUsersService {
    void register(RegisterUserDto registerUserDto);
}
