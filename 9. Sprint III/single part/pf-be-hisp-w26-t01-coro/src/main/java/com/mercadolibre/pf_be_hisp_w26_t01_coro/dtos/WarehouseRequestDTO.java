package com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseRequestDTO {
    private String name;
    private String city;
    private String province;
    private ManagerRequestDTO manager;
}
