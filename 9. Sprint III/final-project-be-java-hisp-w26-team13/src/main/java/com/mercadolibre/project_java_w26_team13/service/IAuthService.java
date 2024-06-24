package com.mercadolibre.project_java_w26_team13.service;


import com.mercadolibre.project_java_w26_team13.dtos.AuthResponseDto;
import com.mercadolibre.project_java_w26_team13.dtos.LoginRequestDto;
import com.mercadolibre.project_java_w26_team13.dtos.RegisterRequestDto;

public interface IAuthService {
    AuthResponseDto login(LoginRequestDto userDto);
    AuthResponseDto register(RegisterRequestDto userToRegisterDto);
}
