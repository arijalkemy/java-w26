package com.mercadolibre.sprint3_individual_perez.service;


import com.mercadolibre.sprint3_individual_perez.dto.request.LoginRequestDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.RegisterRequestDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.AuthResponseDTO;

public interface IAuthService {
    AuthResponseDTO login(LoginRequestDTO userDto);
    AuthResponseDTO register(RegisterRequestDTO userToRegisterDto);
    AuthResponseDTO registerAdmin(RegisterRequestDTO userToRegisterDto);
    AuthResponseDTO registerSeller(RegisterRequestDTO userToRegisterDto);
}
