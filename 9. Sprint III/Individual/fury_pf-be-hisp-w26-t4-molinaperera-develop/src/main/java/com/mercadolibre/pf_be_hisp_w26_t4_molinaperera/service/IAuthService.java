package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.service;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.LoginRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.RegisterRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.AuthResponseDTO;

public interface IAuthService {
    AuthResponseDTO login(LoginRequestDTO user);
    AuthResponseDTO register(RegisterRequestDTO user);
}
