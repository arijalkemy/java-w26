package com.mercadolibre.project_be_java_hisp_w26_team5.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {
    private String token;
}
