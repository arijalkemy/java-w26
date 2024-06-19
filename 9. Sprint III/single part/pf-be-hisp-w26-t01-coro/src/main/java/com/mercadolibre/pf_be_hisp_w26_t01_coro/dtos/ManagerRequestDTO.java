package com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerRequestDTO {
    private String name;
    private String email;
    private String password;
}
