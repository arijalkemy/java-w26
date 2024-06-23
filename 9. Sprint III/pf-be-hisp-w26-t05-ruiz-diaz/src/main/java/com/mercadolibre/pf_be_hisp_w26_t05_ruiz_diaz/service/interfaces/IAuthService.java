package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.LoginRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.RegisterRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.LoginResponseDTO;

public interface IAuthService {
    LoginResponseDTO login(LoginRequestDTO userDto);
    LoginResponseDTO register(RegisterRequestDTO userToRegisterDto);
}
