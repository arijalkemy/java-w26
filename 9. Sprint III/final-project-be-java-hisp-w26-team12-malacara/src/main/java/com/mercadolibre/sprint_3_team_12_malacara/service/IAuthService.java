package com.mercadolibre.sprint_3_team_12_malacara.service;


import com.mercadolibre.sprint_3_team_12_malacara.dto.request.LoginRequestDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.request.RegisterRequestDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.AuthResponseDTO;

public interface IAuthService {
    AuthResponseDTO login(LoginRequestDTO userDto);
    AuthResponseDTO register(RegisterRequestDTO userToRegisterDto);
    AuthResponseDTO registerAdmin(RegisterRequestDTO userToRegisterDto);
}
