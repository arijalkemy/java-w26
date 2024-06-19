package com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.frescos;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BatchPickingDTO {
    private Integer batchId;
    private int quantity;
}
