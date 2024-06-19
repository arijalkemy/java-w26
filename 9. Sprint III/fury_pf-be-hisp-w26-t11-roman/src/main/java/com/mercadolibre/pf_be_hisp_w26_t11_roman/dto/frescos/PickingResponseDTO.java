package com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.frescos;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PickingResponseDTO {
    Integer orderId;
    private List<ProductPickingDTO> products;
}
