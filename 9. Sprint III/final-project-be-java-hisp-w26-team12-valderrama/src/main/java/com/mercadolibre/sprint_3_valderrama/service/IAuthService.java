package com.mercadolibre.sprint_3_valderrama.service;


import com.mercadolibre.sprint_3_valderrama.dto.request.LoginRequestDTO;
import com.mercadolibre.sprint_3_valderrama.dto.request.RegisterRequestDTO;
import com.mercadolibre.sprint_3_valderrama.dto.response.AuthResponseDTO;

public interface IAuthService {
    AuthResponseDTO login(LoginRequestDTO userDto);
    AuthResponseDTO register(RegisterRequestDTO userToRegisterDto);
    AuthResponseDTO registerAdmin(RegisterRequestDTO userToRegisterDto);
}
