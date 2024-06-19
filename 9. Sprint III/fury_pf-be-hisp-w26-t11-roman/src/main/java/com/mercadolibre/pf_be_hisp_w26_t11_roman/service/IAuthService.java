package com.mercadolibre.pf_be_hisp_w26_t11_roman.service;

import com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.auth.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.auth.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.auth.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
