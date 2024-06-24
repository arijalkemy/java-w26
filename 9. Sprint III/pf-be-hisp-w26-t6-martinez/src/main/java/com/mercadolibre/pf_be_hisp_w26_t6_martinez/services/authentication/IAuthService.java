package com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.authentication;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.LoginResponseDto;

public interface IAuthService {

    LoginResponseDto login(LoginRequestDto loginRequest);

}
