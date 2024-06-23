package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}
