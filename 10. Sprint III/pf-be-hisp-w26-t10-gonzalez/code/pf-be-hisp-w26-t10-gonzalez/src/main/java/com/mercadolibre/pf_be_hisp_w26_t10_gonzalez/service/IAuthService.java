package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
