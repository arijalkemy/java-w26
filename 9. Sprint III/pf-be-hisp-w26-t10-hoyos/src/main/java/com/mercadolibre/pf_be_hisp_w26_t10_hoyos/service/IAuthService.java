package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service;


import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
