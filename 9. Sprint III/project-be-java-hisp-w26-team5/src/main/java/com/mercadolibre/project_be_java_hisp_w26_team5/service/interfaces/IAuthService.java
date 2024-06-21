package com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.LoginRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.RegisterRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.LoginResponseDTO;

public interface IAuthService {
    LoginResponseDTO login(LoginRequestDTO userDto);
    LoginResponseDTO register(RegisterRequestDTO userToRegisterDto);
}
