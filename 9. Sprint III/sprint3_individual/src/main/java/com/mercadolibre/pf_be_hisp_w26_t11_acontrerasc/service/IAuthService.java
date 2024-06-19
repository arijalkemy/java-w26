package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.service;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.auth.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.auth.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.auth.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
