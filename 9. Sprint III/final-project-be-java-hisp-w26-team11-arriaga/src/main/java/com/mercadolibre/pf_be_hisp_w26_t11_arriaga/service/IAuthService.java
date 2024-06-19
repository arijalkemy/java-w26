package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.service;


import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.auth.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.auth.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.auth.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
