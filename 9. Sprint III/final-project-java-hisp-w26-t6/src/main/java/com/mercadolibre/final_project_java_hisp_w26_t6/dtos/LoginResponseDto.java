package com.mercadolibre.final_project_java_hisp_w26_t6.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    @JsonProperty("access_token")
    private String accessToken;
}
