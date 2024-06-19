package com.mercadolibre.final_project_java_h_w26_t10.service;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.AuthResponseDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.LoginRequestDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
