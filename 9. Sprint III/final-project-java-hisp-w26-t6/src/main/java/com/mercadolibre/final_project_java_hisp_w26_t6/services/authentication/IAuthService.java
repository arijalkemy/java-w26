package com.mercadolibre.final_project_java_hisp_w26_t6.services.authentication;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.LoginRequestDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.LoginResponseDto;

public interface IAuthService {

    LoginResponseDto login(LoginRequestDto loginRequest);

}
