package com.mercadolibre.pf_be_hisp_w26_t4_aquino.service;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.AuthResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.request.LoginRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.request.RegisterRequestDTO;

public interface IAuthService {
    AuthResponseDTO login(LoginRequestDTO user);
    AuthResponseDTO register(RegisterRequestDTO user);
}
