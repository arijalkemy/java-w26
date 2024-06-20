package com.mercadolibre.pf_be_hisp_w26_t10_meza.service;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
