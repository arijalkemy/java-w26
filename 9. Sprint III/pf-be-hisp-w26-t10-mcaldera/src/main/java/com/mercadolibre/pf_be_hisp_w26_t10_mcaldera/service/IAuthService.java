package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
