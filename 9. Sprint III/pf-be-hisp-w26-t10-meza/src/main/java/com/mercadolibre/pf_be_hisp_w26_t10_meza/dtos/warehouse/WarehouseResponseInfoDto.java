package com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseResponseInfoDto {

    Integer id;
    String name;
}
