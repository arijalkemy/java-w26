package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos;


import com.mercadolibre.pf_be_hisp_w26_t11_arriaga.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepresentativeResponseDTO {
    private Integer warehouseCode;
    private String firstName;
    private String lastName;
    private Role role;
}
