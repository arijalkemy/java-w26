package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.AuthResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request.LoginRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request.RegisterRequestDTO;

public interface IAuthService {
    AuthResponseDTO login(LoginRequestDTO user);
    AuthResponseDTO register(RegisterRequestDTO user);
}
