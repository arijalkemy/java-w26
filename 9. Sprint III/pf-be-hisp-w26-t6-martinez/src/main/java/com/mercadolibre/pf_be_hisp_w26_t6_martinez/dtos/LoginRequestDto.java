package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto implements Serializable {

    private String username;
    private String password;
}
