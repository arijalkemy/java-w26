package com.mercadolibre.sprint_3_team_12.service;


import com.mercadolibre.sprint_3_team_12.dto.request.LoginRequestDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.RegisterRequestDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.AuthResponseDTO;

public interface IAuthService {
    AuthResponseDTO login(LoginRequestDTO userDto);
    AuthResponseDTO register(RegisterRequestDTO userToRegisterDto);
    AuthResponseDTO registerAdmin(RegisterRequestDTO userToRegisterDto);
}
