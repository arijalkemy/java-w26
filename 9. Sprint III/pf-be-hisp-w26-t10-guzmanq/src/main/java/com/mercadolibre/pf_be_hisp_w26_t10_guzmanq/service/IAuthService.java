package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
