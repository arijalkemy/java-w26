package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
