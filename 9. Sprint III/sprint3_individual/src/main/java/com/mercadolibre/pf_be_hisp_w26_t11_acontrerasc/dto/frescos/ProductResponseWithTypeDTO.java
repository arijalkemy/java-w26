package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.frescos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseWithTypeDTO {
    private String name;
    private String type;
    private Double price;
    private Integer batchNumber;
}
