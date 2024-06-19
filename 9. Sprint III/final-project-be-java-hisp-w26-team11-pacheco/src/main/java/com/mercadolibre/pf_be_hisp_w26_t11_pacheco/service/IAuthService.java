package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.service;

import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.auth.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.auth.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.auth.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
