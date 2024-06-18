package com.mercadolibre.meli_frescos.service;

import com.mercadolibre.meli_frescos.dto.auth.AuthResponseDto;
import com.mercadolibre.meli_frescos.dto.auth.LoginRequestDto;
import com.mercadolibre.meli_frescos.dto.auth.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
