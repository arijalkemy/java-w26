package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {
    private String token;
}
