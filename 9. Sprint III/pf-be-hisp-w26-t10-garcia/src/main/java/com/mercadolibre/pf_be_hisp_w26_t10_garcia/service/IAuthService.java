package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
