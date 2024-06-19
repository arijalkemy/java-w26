package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.frescos;

import jnr.ffi.annotations.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWarehouseUpdateRequestDTO {
    private Integer quantity;
}
